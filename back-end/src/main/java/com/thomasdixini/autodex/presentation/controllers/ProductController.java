package com.thomasdixini.autodex.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thomasdixini.autodex.application.dtos.product.calculateProduction.CalculateProductionOutputDto;
import com.thomasdixini.autodex.application.dtos.product.create.CreateProductInputDto;
import com.thomasdixini.autodex.application.dtos.product.create.CreateProductOutputDto;
import com.thomasdixini.autodex.application.dtos.product.findAll.FindAllProductsOutputDto;
import com.thomasdixini.autodex.application.usecases.CalculateProductionCapacityUseCase;
import com.thomasdixini.autodex.application.usecases.CreateProductUseCase;
import com.thomasdixini.autodex.application.usecases.FindAllProductsUseCase;
import com.thomasdixini.autodex.presentation.dtos.productDtos.CreateProductRequest;



@RestController
@RequestMapping ("/products")
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final CalculateProductionCapacityUseCase calculateProductionCapacityUseCase;
    private final FindAllProductsUseCase findAllProductsUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, CalculateProductionCapacityUseCase calculateProductionCapacityUseCase, FindAllProductsUseCase findAllProductsUseCase) {
        super();
        this.createProductUseCase = createProductUseCase;
        this.calculateProductionCapacityUseCase = calculateProductionCapacityUseCase;
        this.findAllProductsUseCase = findAllProductsUseCase;
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

    @GetMapping
    public ResponseEntity<FindAllProductsOutputDto> getProducts() {
        return ResponseEntity.ok(findAllProductsUseCase.execute());
    }

    @GetMapping("/production-capacity")
    public ResponseEntity<CalculateProductionOutputDto> getProductsCapacity() {
        return ResponseEntity.ok(calculateProductionCapacityUseCase.execute());
    }
    
    
}
