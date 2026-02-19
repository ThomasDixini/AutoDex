package com.thomasdixini.autodex.application.dtos.product.calculateProduction;

import java.util.List;

public record CalculateProductionOutputDto(
    List<ProductForProduction> productsToProduce
) {

}
