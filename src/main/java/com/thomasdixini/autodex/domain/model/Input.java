package com.thomasdixini.autodex.domain.model;

import java.util.List;

public class Input {
    private int inputCode;
    private String name;
    private int quantityInStock;
    private List<InputProduct> inputs;

    public Input(int inputCode, String name, int quantity_in_stock) {
        this.inputCode = inputCode;
        this.name = name;
        this.quantityInStock = quantity_in_stock;
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
}
