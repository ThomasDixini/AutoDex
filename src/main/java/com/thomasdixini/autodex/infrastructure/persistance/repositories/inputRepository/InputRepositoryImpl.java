package com.thomasdixini.autodex.infrastructure.persistance.repositories.inputRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.thomasdixini.autodex.domain.model.Input;
import com.thomasdixini.autodex.domain.repositories.InputRepository;
import com.thomasdixini.autodex.infrastructure.persistance.entity.InputEntity;

@Repository
public class InputRepositoryImpl implements InputRepository {
    private final JPAInputRepository jpaInputRepository;

    public InputRepositoryImpl(JPAInputRepository jpaInputRepository) {
        this.jpaInputRepository = jpaInputRepository;
    }

    @Override
    public Input create(Input input) {
        return toDomain(this.jpaInputRepository.save(toEntity(input)));
    }

    @Override
    public Input findById(int id) {
        InputEntity entity = this.jpaInputRepository.findById(id).orElse(null);
        if(entity == null) {
            return null;
        }
        return toDomain(entity);
    }

    @Override
    public List<Input> findAllByProductId(Long productId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Input toDomain(InputEntity entity) {
        return new Input(entity.getInputCode(), entity.getName(), entity.getQuantityInStock());
    }

    private InputEntity toEntity(Input input) {
        InputEntity entity = new InputEntity();
        entity.setInputCode(input.getInputCode());
        entity.setName(input.getName());
        entity.setQuantityInStock(input.getQuantityInstock());
        return entity;
    }
}
