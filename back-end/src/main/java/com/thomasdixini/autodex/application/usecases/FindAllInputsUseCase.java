
package com.thomasdixini.autodex.application.usecases;

import com.thomasdixini.autodex.application.dtos.input.findAll.FindAllInputsOutputDto;
import com.thomasdixini.autodex.application.dtos.input.findAll.InputOutputDto;
import com.thomasdixini.autodex.domain.repositories.InputRepository;

public class FindAllInputsUseCase {
    private final InputRepository inputRepository;

    public FindAllInputsUseCase(InputRepository inputRepository) {
        this.inputRepository = inputRepository;
    }

    public FindAllInputsOutputDto execute(){
        var inputs = inputRepository.findAll();
        var inputsOutputDto = inputs.stream()
            .map(input -> new InputOutputDto(
                input.getInputCode(),
                input.getName(),
                input.getQuantityInstock()
            ))
            .toList();
        return new FindAllInputsOutputDto(inputsOutputDto);
    }
}
