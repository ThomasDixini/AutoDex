package com.thomasdixini.autodex.domain.model;

public class InputProduct {
    private Product product;
    private Input input;
    private int quantityForProduction;

    public InputProduct(Product product, Input input, int quantityForProduction) {
        this.product = product;
        this.input = input;
        this.quantityForProduction = quantityForProduction;
    }

    public Product getProduct() {
        return product;
    }

    public Input getInput() {
        return input;
    }

    public int getQuantityForProduction() {
        return quantityForProduction;
    }
}
