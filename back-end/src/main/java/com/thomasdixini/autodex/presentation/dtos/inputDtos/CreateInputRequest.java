package com.thomasdixini.autodex.presentation.dtos.inputDtos;

public record CreateInputRequest(
    int inputCode,
    String name,
    int quantityInStock
) {
    public CreateInputRequest {
        if (inputCode <= 0) {
            throw new IllegalArgumentException("Input code must be greater than zero.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        if (quantityInStock < 0) {
            throw new IllegalArgumentException("Quantity in stock cannot be negative.");
        }
    }
}
