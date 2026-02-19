package com.thomasdixini.autodex.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "input_products",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"product_id", "input_id"})
    }
)
public class InputProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "input_id", nullable = false)
    private InputEntity input;
    
    private Integer quantityForProduction;

    public InputProductEntity() {
    }

    public InputProductEntity(Long id, ProductEntity product, InputEntity input, Integer quantityForProduction) {
        this.id = id;
        this.product = product;
        this.input = input;
        this.quantityForProduction = quantityForProduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public InputEntity getInput() {
        return input;
    }

    public void setInput(InputEntity input) {
        this.input = input;
    }

    public Integer getQuantityForProduction() {
        return quantityForProduction;
    }

    public void setQuantityForProduction(Integer quantityForProduction) {
        this.quantityForProduction = quantityForProduction;
    }
}
