package com.thomasdixini.autodex.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private int id;
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
    
    public Input(int id, int inputCode, String name, int quantity_in_stock) {
        this.id = id;
        this.inputCode = inputCode;
        this.name = name;
        this.quantityInStock = quantity_in_stock;
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getInputCode() {
        return inputCode;
    }

    public String getName() {
        return name;
    }

    public int getQuantityInstock() {
        return quantityInStock;
    }

    public List<InputProduct> getProducts() {
        return products;
    }

    public void addInputProduct(Product product, int quantityForProduction) {
        InputProduct ip = new InputProduct(product, this, quantityForProduction);
        this.products.add(ip);
        product.getInputs().add(ip);
    }
}
