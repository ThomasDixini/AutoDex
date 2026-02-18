package com.thomasdixini.autodex.infrastructure.persistance.repositories.productRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.thomasdixini.autodex.domain.model.Product;
import com.thomasdixini.autodex.domain.repositories.ProductRepository;
import com.thomasdixini.autodex.infrastructure.persistance.entity.ProductEntity;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final JPAProductRepository jpaProductRepository;

    public ProductRepositoryImpl(JPAProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product create(Product product) {
        return toDomain(jpaProductRepository.save(toEntity(product)));
    }

    @Override
    public Product findById(int id) {
        ProductEntity entity = this.jpaProductRepository.findById(id).orElse(null);
        if(entity == null) {
            return null;
        }
        return toDomain(entity);
    }

    @Override
    public List<Product> findAllByPriority() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setProductCode(product.getProductCode());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        return entity;
    }

    private Product toDomain(ProductEntity entity) {
        return new Product(entity.getProductCode(), entity.getName(), entity.getPrice());
    }
}
