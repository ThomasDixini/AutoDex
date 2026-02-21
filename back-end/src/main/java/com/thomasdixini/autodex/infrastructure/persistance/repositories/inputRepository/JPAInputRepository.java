package com.thomasdixini.autodex.infrastructure.persistance.repositories.inputRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thomasdixini.autodex.infrastructure.persistance.entity.InputEntity;

public interface JPAInputRepository extends JpaRepository<InputEntity, Integer> {
	Optional<InputEntity> findByInputCode(Integer inputCode);

	@Query("""
        SELECT i
        FROM InputEntity i
		WHERE CAST(i.inputCode AS string) = :codeOrName OR i.name = :codeOrName
    """)
	Optional<InputEntity> findByCodeOrName(@Param("codeOrName") String codeOrName);
}
