package com.thomasdixini.autodex.domain.repositories;

import java.util.List;

import com.thomasdixini.autodex.domain.model.Input;

public interface  InputRepository {
    Input create(Input input);
    Input findById(int id);
    List<Input> findAllByProductId(Long productId);
}
