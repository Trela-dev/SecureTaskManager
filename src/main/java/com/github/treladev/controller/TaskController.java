package com.github.treladev.controller;

import com.github.treladev.Service.TaskService;
import com.github.treladev.model.common.mapper.TaskMapper;
import com.github.treladev.model.dto.AddTaskDto;
import com.github.treladev.model.dto.ResponseTaskDto;
import com.github.treladev.model.TaskEntity;
import com.github.treladev.model.UserEntity;

import com.github.treladev.model.dto.UpdateTaskDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    // Constructor with dependency injection
    public TaskController(TaskService taskService, TaskMapper taskEntityToResponseTaskDtoMapper) {
        this.taskService = taskService;
        this.taskMapper = taskEntityToResponseTaskDtoMapper;
    }

    // Get single task by ID
    @GetMapping("/tasks/{id}")
    public ResponseEntity<ResponseTaskDto> getTask(@PathVariable Long id) {
        TaskEntity task = taskService.getTask(id);
        ResponseTaskDto responseTaskDto = taskMapper.toResponseDto(task);
        return ResponseEntity.ok(responseTaskDto);
    }

    // Get all tasks (admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/tasks")
    public ResponseEntity<List<ResponseTaskDto>> getAllTasks(){
        List<TaskEntity> tasks = taskService.getAllTasks();
        List<ResponseTaskDto> responseTaskDtos = taskMapper.toResponseDtoList(tasks);
        return ResponseEntity.ok(responseTaskDtos);
    }

    // Create new task (admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/tasks")
    public ResponseEntity<ResponseTaskDto> createTask(@Valid @RequestBody AddTaskDto addTaskDto){
        UserEntity owner = taskService.findOwnerByUsername(addTaskDto.getOwnerUsername());
        TaskEntity newTaskEntity = taskService.createTask(new TaskEntity(owner, addTaskDto.getDescription(), addTaskDto.getDeadline()));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskMapper.toResponseDto(newTaskEntity));
    }

    // Update existing task (admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/tasks/{id}")
    public ResponseEntity<ResponseTaskDto> updateTask(@PathVariable Long id, @Valid @RequestBody UpdateTaskDto updateTaskDto){
        TaskEntity updatedTaskEntity = taskService.updateTask(id, updateTaskDto.getOwnerUsername(),
                updateTaskDto.getDescription(), updateTaskDto.getDeadline(), updateTaskDto.getStatus());
        return ResponseEntity.ok(taskMapper.toResponseDto(updatedTaskEntity));
    }
}