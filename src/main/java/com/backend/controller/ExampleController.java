package com.backend.controller;

import com.backend.dto.CreateExampleDto;
import com.backend.entity.Example;
import com.backend.response.ExampleCreatedResponse;
import com.backend.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/")
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping("example")
    public ResponseEntity<List<Example>> findAllExamples() {
        return ResponseEntity.ok(exampleService.findAll());
    }

    @PostMapping("example")
    public ResponseEntity<ExampleCreatedResponse> createExample(@RequestBody CreateExampleDto dto) {
        return new ResponseEntity<>(exampleService.createExample(dto)
                ,HttpStatus.CREATED);
    }


}
