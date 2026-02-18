package com.thomasdixini.autodex.infrastructure.persistance.repositories.productRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thomasdixini.autodex.infrastructure.persistance.entity.ProductEntity;

public interface JPAProductRepository extends JpaRepository<ProductEntity, Integer> {}
