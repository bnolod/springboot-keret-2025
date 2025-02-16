package com.backend.response;

import com.backend.entity.Example;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class ExampleCreatedResponse {
    private Long id;
    private String name;
    private final String message = "szép munka!";

    public ExampleCreatedResponse(Example ex) {
        this.id = ex.getId();
        this.name = ex.getName();
    }
}
