package com.thomasdixini.autodex.application.usecases;

import com.thomasdixini.autodex.application.dtos.product.findAll.FindAllProductsOutputDto;
import com.thomasdixini.autodex.domain.repositories.ProductRepository;

public class FindAllProductsUseCase {
    private final ProductRepository productRepository;
    
    public FindAllProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public FindAllProductsOutputDto execute() {
        return new FindAllProductsOutputDto(productRepository.findAll().stream().map(product -> new FindAllProductsOutputDto.ProductOutputDto(
            product.getId(),
            product.getProductCode(),
            product.getName(),
            product.getPrice()
        )).toList());
    }
}
