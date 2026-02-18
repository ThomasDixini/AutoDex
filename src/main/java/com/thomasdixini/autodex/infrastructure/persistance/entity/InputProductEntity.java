package com.thomasdixini.autodex.infrastructure.persistance.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "input_products")
public class InputProductEntity {
    @EmbeddedId
    private InputProductId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @MapsId("inputId")
    @JoinColumn(name = "input_id")
    private InputEntity input;
    
    private Integer quantityForProduction;

    public InputProductEntity() {
    }

    public InputProductEntity(InputProductId id, ProductEntity product, InputEntity input, Integer quantityForProduction) {
        this.id = id;
        this.product = product;
        this.input = input;
        this.quantityForProduction = quantityForProduction;
    }

    public InputProductId getId() {
        return id;
    }

    public void setId(InputProductId id) {
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
