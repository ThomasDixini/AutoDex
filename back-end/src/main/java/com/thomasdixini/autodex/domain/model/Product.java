package com.thomasdixini.autodex.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private int productCode;
    private String name;
    private double price;
    private List<InputProduct> inputs;

    public Product(int id, int productCode, String name, double price) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.inputs = new ArrayList<>();
    }
    
    public Product(int productCode, String name, double price) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.inputs = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<InputProduct> getInputs() {
        return inputs;
    }

    public void addInputProduct(Input input, int quantityForProduction) {
        InputProduct ip = new InputProduct(this, input, quantityForProduction);
        this.inputs.add(ip);
        input.getProducts().add(ip);
    }
}
