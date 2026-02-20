package com.thomasdixini.autodex.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thomasdixini.autodex.application.dtos.input.create.CreateInputDto;
import com.thomasdixini.autodex.application.dtos.input.create.CreateInputOutputDto;
import com.thomasdixini.autodex.application.usecases.CreateInputUseCase;
import com.thomasdixini.autodex.presentation.dtos.inputDtos.CreateInputRequest;


@RestController
@RequestMapping("/inputs")
public class InputController {
    private final CreateInputUseCase createInputUseCase;

    public InputController(CreateInputUseCase createInputUseCase) {
        super();
        this.createInputUseCase = createInputUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateInputOutputDto> createInput(@RequestBody CreateInputRequest request) {
        CreateInputDto inputDto = new CreateInputDto(
            request.inputCode(),
            request.name(),
            request.quantityInStock()
        );
        return ResponseEntity.ok(createInputUseCase.execute(inputDto));
    }
    
}
