package com.github.treladev.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class AddTaskDto {
    @NotBlank(message = "Owner username is required")
    private String ownerUsername;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Deadline is required")
    private LocalDateTime deadline;

}
