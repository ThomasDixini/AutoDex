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

    public void setProduct(Product product) {
        this.product = product;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public int getQuantityForProduction() {
        return quantityForProduction;
    }

    public void setQuantityForProduction(int quantityForProduction) {
        this.quantityForProduction = quantityForProduction;
    }
}
