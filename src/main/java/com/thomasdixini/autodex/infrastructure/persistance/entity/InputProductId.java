package com.thomasdixini.autodex.infrastructure.persistance.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class InputProductId implements Serializable {
    private Long inputId;
    private Long productId;

    public InputProductId() {
    }

    public InputProductId(Long inputId, Long productId) {
        this.inputId = inputId;
        this.productId = productId;
    }

    public Long getInputId() {
        return inputId;
    }

    public void setInputId(Long inputId) {
        this.inputId = inputId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputProductId that = (InputProductId) o;
        return Objects.equals(inputId, that.inputId) &&
               Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputId, productId);
    }
}
