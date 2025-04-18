package com.github.treladev.model.dto;

import com.github.treladev.model.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
public class UpdateTaskDto {

    @NotBlank(message = "Owner username is required")
    private String ownerUsername;
    @NotBlank(message = "Description is required")
    private String description;
    private LocalDateTime deadline;
    private TaskStatus status;

}
