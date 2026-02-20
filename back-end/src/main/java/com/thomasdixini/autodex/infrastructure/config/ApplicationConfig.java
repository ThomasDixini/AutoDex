package com.thomasdixini.autodex.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thomasdixini.autodex.application.usecases.CalculateProductionCapacityUseCase;
import com.thomasdixini.autodex.application.usecases.CreateInputUseCase;
import com.thomasdixini.autodex.application.usecases.CreateProductUseCase;
import com.thomasdixini.autodex.application.usecases.FindAllInputsUseCase;
import com.thomasdixini.autodex.domain.repositories.InputRepository;
import com.thomasdixini.autodex.domain.repositories.ProductRepository;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(
            ProductRepository productRepository,
            InputRepository inputRepository) {
        return new CreateProductUseCase(productRepository, inputRepository);
    }

    @Bean
    public CreateInputUseCase createInputUseCase(InputRepository inputRepository) {
        return new CreateInputUseCase(inputRepository);
    }

    @Bean
    public CalculateProductionCapacityUseCase calculateProductionCapacityUseCase(ProductRepository productRepository, InputRepository inputRepository) {
        return new CalculateProductionCapacityUseCase(productRepository, inputRepository);
    }

    @Bean
    public FindAllInputsUseCase findAllInputsUseCase(InputRepository inputRepository) {
        return new FindAllInputsUseCase(inputRepository);
    }
}
