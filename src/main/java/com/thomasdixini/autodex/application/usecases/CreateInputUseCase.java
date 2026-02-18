package com.thomasdixini.autodex.application.usecases;

import com.thomasdixini.autodex.application.dtos.input.create.CreateInputDto;
import com.thomasdixini.autodex.application.dtos.input.create.CreateInputOutputDto;
import com.thomasdixini.autodex.domain.model.Input;
import com.thomasdixini.autodex.domain.repositories.InputRepository;

public class CreateInputUseCase {
    private final InputRepository inputRepository;

    public CreateInputUseCase(InputRepository inputRepository) {
        this.inputRepository = inputRepository;
    }

    public CreateInputOutputDto execute(CreateInputDto request) {
        Input input = new Input(
            request.inputCode(),
            request.name(),
            request.quantityInStock()
        );
        Input output = this.inputRepository.create(input);
        return new CreateInputOutputDto(
            output.getInputCode(),
            output.getName(),
            output.getQuantityInstock()
        );
    }
}
