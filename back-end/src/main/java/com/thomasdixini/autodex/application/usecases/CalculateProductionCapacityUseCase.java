package com.thomasdixini.autodex.application.usecases;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.thomasdixini.autodex.application.dtos.product.calculateProduction.CalculateProductionOutputDto;
import com.thomasdixini.autodex.application.dtos.product.calculateProduction.ProductForProduction;
import com.thomasdixini.autodex.domain.model.Input;
import com.thomasdixini.autodex.domain.model.Product;
import com.thomasdixini.autodex.domain.repositories.InputRepository;
import com.thomasdixini.autodex.domain.repositories.ProductRepository;

public class CalculateProductionCapacityUseCase {
    private final ProductRepository productRepository;
    private final InputRepository inputRepository;

    public CalculateProductionCapacityUseCase(ProductRepository productRepository, InputRepository inputRepository) {
        this.productRepository = productRepository;
        this.inputRepository = inputRepository;
    }

    public CalculateProductionOutputDto execute(){
        List<Input> inputsAvailable = inputRepository.findAllWithStockAvailable();
        Map<Integer, Integer> stockMap = inputsAvailable.stream().collect(Collectors.toMap(Input::getInputCode, Input::getQuantityInstock));

        List<Product> productsProducibles = productRepository.findAllByInputs(inputsAvailable);


            List<ProductForProduction> productsForProduction = productsProducibles.stream().map(p -> {
                int maxProduction = p.getInputs()
                .stream()
                .mapToInt(ip -> stockMap.getOrDefault(ip.getInput().getInputCode(), 0) / ip.getQuantityForProduction())
                .min()
                .orElse(0);

                return new ProductForProduction(p.getName(), maxProduction, maxProduction * p.getPrice());
            })
            .sorted(Comparator.comparing(ProductForProduction::total).reversed())
            .toList();
        
        return new CalculateProductionOutputDto(productsForProduction);
    }
}
