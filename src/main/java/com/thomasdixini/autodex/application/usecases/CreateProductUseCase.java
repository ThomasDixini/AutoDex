package com.thomasdixini.autodex.application.usecases;

import com.thomasdixini.autodex.application.dtos.product.create.CreateProductInputDto;
import com.thomasdixini.autodex.application.dtos.product.create.CreateProductOutputDto;
import com.thomasdixini.autodex.application.dtos.product.create.InputForProductDto;
import com.thomasdixini.autodex.domain.model.Input;
import com.thomasdixini.autodex.domain.model.Product;
import com.thomasdixini.autodex.domain.repositories.InputRepository;
import com.thomasdixini.autodex.domain.repositories.ProductRepository;

public class CreateProductUseCase {
    private final ProductRepository productRepository;
    private final InputRepository inputRepository;

    public CreateProductUseCase(ProductRepository productRepository, InputRepository inputRepository) {
        this.productRepository = productRepository;
        this.inputRepository = inputRepository;
    }

    public CreateProductOutputDto execute(CreateProductInputDto request){
        Product product = new Product(
            request.productCode(),
            request.name(),
            request.price()
        );

        for (InputForProductDto ref : request.inputs()) {

            Input inputFound = inputRepository.findById(ref.inputId());

            if (inputFound == null) {
                throw new IllegalArgumentException(
                        "Input not found: " + ref.inputId()
                );
            }

            product.addInputProduct(inputFound, ref.quantity());
        }
        
        productRepository.create(product);

        return new CreateProductOutputDto(
            product.getProductCode(),
            product.getName(),
            product.getPrice()
        );
    }
}
