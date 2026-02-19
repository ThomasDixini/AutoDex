package com.thomasdixini.autodex.infrastructure.persistance.repositories.productRepository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thomasdixini.autodex.domain.model.InputProduct;
import com.thomasdixini.autodex.domain.model.Product;
import com.thomasdixini.autodex.domain.repositories.ProductRepository;
import com.thomasdixini.autodex.infrastructure.persistance.entity.InputEntity;
import com.thomasdixini.autodex.infrastructure.persistance.entity.InputProductEntity;
import com.thomasdixini.autodex.infrastructure.persistance.entity.ProductEntity;
import com.thomasdixini.autodex.infrastructure.persistance.repositories.inputRepository.JPAInputRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final JPAProductRepository jpaProductRepository;
    private final JPAInputRepository jpaInputRepository;

    public ProductRepositoryImpl(JPAProductRepository jpaProductRepository, JPAInputRepository jpaInputRepository) {
        this.jpaProductRepository = jpaProductRepository;
        this.jpaInputRepository = jpaInputRepository;
    }

    @Override
    @Transactional
    public Product create(Product product) {
        ProductEntity entity = toEntity(product);

        if (product.getInputs() != null) {
            for (InputProduct ip : product.getInputs()) {
                InputEntity inputEntity = jpaInputRepository.findByInputCode(ip.getInput().getInputCode())
                    .orElseThrow(() -> new IllegalArgumentException("Input not found: " + ip.getInput().getInputCode()));

                InputProductEntity ipEntity = new InputProductEntity();
                ipEntity.setProduct(entity);
                ipEntity.setInput(inputEntity);
                ipEntity.setQuantityForProduction(ip.getQuantityForProduction());

                entity.getInputProducts().add(ipEntity);
            }
        }

        ProductEntity saved = jpaProductRepository.save(entity);
        return toDomain(saved);
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
