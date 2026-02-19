package com.thomasdixini.autodex.application.dtos.input.create;

public record CreateInputDto(
    int inputCode,
    String name,
    int quantityInStock
) { }
