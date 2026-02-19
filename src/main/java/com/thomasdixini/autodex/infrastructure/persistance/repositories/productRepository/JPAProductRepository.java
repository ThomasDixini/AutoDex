package com.thomasdixini.autodex.infrastructure.persistance.repositories.productRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thomasdixini.autodex.infrastructure.persistance.entity.InputEntity;
import com.thomasdixini.autodex.infrastructure.persistance.entity.ProductEntity;

public interface JPAProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query("""
        SELECT DISTINCT p
        FROM ProductEntity p
        JOIN p.inputProducts ip
        JOIN ip.input i
        WHERE i IN :inputs
    """)
    List<ProductEntity> findByInputs(List<InputEntity> inputs);
}
