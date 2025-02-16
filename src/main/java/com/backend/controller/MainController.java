package com.backend.controller;

import com.backend.dto.CreateExampleDto;
import com.backend.entity.Example;
import com.backend.response.ExampleCreatedResponse;
import com.backend.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/")
public class MainController {

    private final MainService mainService;

    @GetMapping("example")
    public ResponseEntity<List<Example>> findAllExamples() {
        return ResponseEntity.ok(mainService.findAll());
    }

    @PostMapping("example")
    public ResponseEntity<ExampleCreatedResponse> createExample(@RequestBody CreateExampleDto dto) {
        return new ResponseEntity<>(mainService.createExample(dto)
                ,HttpStatus.CREATED);
    }


}
