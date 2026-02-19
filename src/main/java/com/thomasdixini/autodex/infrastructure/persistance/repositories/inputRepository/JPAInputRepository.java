package com.thomasdixini.autodex.infrastructure.persistance.repositories.inputRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thomasdixini.autodex.infrastructure.persistance.entity.InputEntity;

public interface JPAInputRepository extends JpaRepository<InputEntity, Integer> {
	Optional<InputEntity> findByInputCode(Integer inputCode);
}
