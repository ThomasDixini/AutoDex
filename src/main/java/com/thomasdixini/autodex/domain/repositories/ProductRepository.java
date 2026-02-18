package com.thomasdixini.autodex.domain.repositories;

import java.util.List;

import com.thomasdixini.autodex.domain.model.Product;

public interface ProductRepository {
    Product create(Product product);
    Product findById(int id);
    List<Product> findAllByPriority();
}
