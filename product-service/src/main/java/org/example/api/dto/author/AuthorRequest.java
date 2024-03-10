package org.example.api.dto.author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthorRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 255, message = "Name must be at most 255 characters long")
        String name
) {

}