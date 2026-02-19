package com.thomasdixini.autodex.application.dtos.product.calculateProduction;

public record ProductForProduction(
    String product,
    Integer quantityToProduce,
    double total
) {
}
