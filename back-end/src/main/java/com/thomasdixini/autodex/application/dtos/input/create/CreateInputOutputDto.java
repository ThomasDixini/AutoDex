package com.thomasdixini.autodex.application.dtos.input.create;

public record CreateInputOutputDto(
    int inputCode,
    String name,
    int quantityInStock
) { }
