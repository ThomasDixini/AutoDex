package com.thomasdixini.autodex.infrastructure.persistance.repositories.productRepository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thomasdixini.autodex.domain.model.Input;
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

    private InputEntity toEntity(Input input) {
        InputEntity entity = new InputEntity();
        entity.setId(input.getId());
        entity.setInputCode(input.getInputCode());
        entity.setName(input.getName());
        entity.setQuantityInStock(input.getQuantityInstock());
        return entity;
    }

    private Product toDomain(ProductEntity entity) {
        var product = new Product(entity.getId(), entity.getProductCode(), entity.getName(), entity.getPrice());
        entity.getInputProducts().forEach(c -> product.addInputProduct(toDomain(c.getInput()), c.getQuantityForProduction()));
        return product;
    }

    private Input toDomain(InputEntity entity) {
        var input = new Input(entity.getId(), entity.getInputCode(), entity.getName(), entity.getQuantityInStock());
        return input;
    }

    @Override
    public List<Product> findAllByInputs(List<Input> inputs) {
        List<InputEntity> inputEntities = inputs.stream()
            .map(this::toEntity)
            .toList();

        return this.jpaProductRepository.findByInputs(inputEntities).stream().map(this::toDomain).toList();
    }

    @Override
    public List<Product> findAll() {
        return this.jpaProductRepository.findAll().stream().map(this::toDomain).toList();
    }
}
