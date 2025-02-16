package com.backend.service;

import com.backend.dto.CreateExampleDto;
import com.backend.entity.Example;
import com.backend.repository.ExampleRepository;
import com.backend.response.ExampleCreatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExampleService {
    private final ExampleRepository exampleRepository;

    public List<Example> findAll() {
        return exampleRepository.findAll();
    }

    public ExampleCreatedResponse createExample(CreateExampleDto dto) {
        if (dto.getName() == null || dto.getDescription() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "minden mezot tolts ki");
        }
        Example example = exampleRepository.save(Example.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build()
        );
        return new ExampleCreatedResponse(example);
    }
}
