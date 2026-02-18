package com.thomasdixini.autodex.infrastructure.persistance.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "inputs")
public class InputEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private Integer inputCode;
    private String name;
    private Integer quantityInStock;

    @OneToMany(mappedBy = "input")
    private List<InputProductEntity> products = new ArrayList<>();

    public InputEntity() {
    }

    public InputEntity(String name, int quantityInStock) {
        this.name = name;
        this.quantityInStock = quantityInStock;
    }

    public Integer getId() {
        return id;
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

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public List<InputProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<InputProductEntity> products) {
        this.products = products;
    }
}
