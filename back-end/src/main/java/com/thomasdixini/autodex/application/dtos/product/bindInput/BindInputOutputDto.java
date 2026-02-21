package com.thomasdixini.autodex.application.dtos.product.bindInput;

public record BindInputOutputDto(
    int inputCode,
    String name,
    int quantityInStock
) {

}
