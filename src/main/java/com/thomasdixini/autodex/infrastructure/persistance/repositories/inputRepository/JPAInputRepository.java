package com.thomasdixini.autodex.infrastructure.persistance.repositories.inputRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thomasdixini.autodex.infrastructure.persistance.entity.InputEntity;

public interface JPAInputRepository extends JpaRepository<InputEntity, Integer> {}
