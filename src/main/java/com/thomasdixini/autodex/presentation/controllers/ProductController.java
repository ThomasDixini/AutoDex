package com.thomasdixini.autodex.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thomasdixini.autodex.application.dtos.product.create.CreateProductInputDto;
import com.thomasdixini.autodex.application.dtos.product.create.CreateProductOutputDto;
import com.thomasdixini.autodex.application.usecases.CreateProductUseCase;
import com.thomasdixini.autodex.presentation.dtos.productDtos.CreateProductRequest;


@RestController
@RequestMapping ("/products")
public class ProductController {
    private final CreateProductUseCase createProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase) {
        super();
        this.createProductUseCase = createProductUseCase;
    }


    @PostMapping
    public ResponseEntity<CreateProductOutputDto> createProduct(@RequestBody CreateProductRequest request) {
        CreateProductInputDto inputDto = new CreateProductInputDto(
            request.productCode(),
            request.name(),
            request.price(),
            request.inputs()
        );

        CreateProductOutputDto output = createProductUseCase.execute(inputDto);

        return ResponseEntity.ok(output);
    }
    
}
