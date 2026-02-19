package com.thomasdixini.autodex.presentation.dtos.productDtos;

import java.util.List;

import com.thomasdixini.autodex.application.dtos.product.create.InputForProductDto;

public record  CreateProductRequest(
    int productCode,
    String name,
    double price,
    List<InputForProductDto> inputs
) {

}
