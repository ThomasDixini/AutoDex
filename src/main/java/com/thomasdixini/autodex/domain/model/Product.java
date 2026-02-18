package com.thomasdixini.autodex.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int productCode;
    private String name;
    private double price;
    private List<InputProduct> inputs;

    public Product(int productCode, String name, double price) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.inputs = new ArrayList<>();
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<InputProduct> getInputs() {
        return inputs;
    }

    public void setInputs(List<InputProduct> inputs) {
        this.inputs = inputs;
    }

    public void addInputProduct(Input input, int quantityForProduction) {
        InputProduct ip = new InputProduct(this, input, quantityForProduction);
        this.inputs.add(ip);
        input.getProducts().add(ip);
    }
}
