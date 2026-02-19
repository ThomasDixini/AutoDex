package com.thomasdixini.autodex.application.dtos.product.create;

public record  CreateProductOutputDto(
    int productCode,
    String name,
    double price
) {}
