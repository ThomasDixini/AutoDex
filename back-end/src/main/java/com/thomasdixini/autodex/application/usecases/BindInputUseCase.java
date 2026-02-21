package com.thomasdixini.autodex.application.usecases;

import com.thomasdixini.autodex.application.dtos.product.bindInput.BindInputDto;
import com.thomasdixini.autodex.application.dtos.product.bindInput.BindInputOutputDto;
import com.thomasdixini.autodex.domain.model.Input;
import com.thomasdixini.autodex.domain.repositories.InputRepository;

public class BindInputUseCase {
    private final InputRepository inputRepository;

    public BindInputUseCase(InputRepository inputRepository) {
        this.inputRepository = inputRepository;
    }

    public BindInputOutputDto execute(BindInputDto request){
        Input input = this.inputRepository.findByCodeOrName(request.codeOrName());
        return new BindInputOutputDto(input.getInputCode(), input.getName(), input.getQuantityInstock());
    }
}
