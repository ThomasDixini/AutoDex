package com.thomasdixini.autodex.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private int inputCode;
    private String name;
    private int quantityInStock;
    private List<InputProduct> products;

    public Input(int inputCode, String name, int quantity_in_stock) {
        this.inputCode = inputCode;
        this.name = name;
        this.quantityInStock = quantity_in_stock;
        this.products = new ArrayList<>();
    }

    public int getInputCode() {
        return inputCode;
    }

    public void setInputCode(int inputCode) {
        this.inputCode = inputCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityInstock() {
        return quantityInStock;
    }

    public void setQuantityInstock(int quantityInstock) {
        this.quantityInStock = quantityInstock;
    }

    public List<InputProduct> getProducts() {
        return products;
    }

    public void setProducts(List<InputProduct> products) {
        this.products = products;
    }

    public void addInputProduct(Product product, int quantityForProduction) {
        InputProduct ip = new InputProduct(product, this, quantityForProduction);
        this.products.add(ip);
        product.getInputs().add(ip);
    }
}
