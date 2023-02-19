package com.hooli.todo.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class NoteDTO {
    @NotBlank(message = "Note title is required.")
    @Size(min = 1, max = 50, message = "Note title must be at least 1 to 50 characters long.")
    private String title;

    @NotBlank(message = "Note description is required.")
    @Size(min = 1, max = 255, message = "Note description must be at least 1 to 255 characters long.")
    private String description;

    @NotNull(message = "Category ID is required.")
    private Long categoryId;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
