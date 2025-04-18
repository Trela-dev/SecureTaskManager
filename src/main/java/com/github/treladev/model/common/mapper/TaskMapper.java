package com.github.treladev.model.common.mapper;

import com.github.treladev.model.TaskEntity;
import com.github.treladev.model.dto.ResponseTaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// Mapper interface for converting between TaskEntity and DTOs
// Uses MapStruct with Spring component model
@Mapper(componentModel = "spring")
public interface TaskMapper {

    // Maps TaskEntity to ResponseTaskDto
    // Specifically maps owner's username from nested object
    @Mapping(target = "ownerUsername", source = "owner.username")
    ResponseTaskDto toResponseDto(TaskEntity task);

    // Maps list of TaskEntity to list of ResponseTaskDto
    List<ResponseTaskDto> toResponseDtoList(List<TaskEntity> tasks);

}