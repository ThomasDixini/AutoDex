package com.thomasdixini.autodex.application.dtos.product.create;

import java.util.List;

public record CreateProductInputDto(
    int productCode,
    String name,
    double price,
    List<InputForProductDto> inputs
) {}
