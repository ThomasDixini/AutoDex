
package com.thomasdixini.autodex.application.dtos.product.findAll;

import java.util.List;

public record FindAllProductsOutputDto(
    List<ProductOutputDto> products
) {
    public record ProductOutputDto(
        int id,
        int productCode,
        String name,
        double price
    ) {

    }
}
