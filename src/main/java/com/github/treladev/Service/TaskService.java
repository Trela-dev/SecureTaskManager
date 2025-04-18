package com.github.treladev.Service;

import com.github.treladev.exception.TaskNotFoundException;
import com.github.treladev.model.TaskEntity;
import com.github.treladev.model.UserEntity;
import com.github.treladev.model.enums.TaskStatus;
import com.github.treladev.repository.TaskRepository;
import com.github.treladev.repository.UserRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository,UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;

    }

    @PostAuthorize("hasPermission(returnObject, 'ROLE_ADMIN')")
    public TaskEntity getTask(Long id) {
        return findTaskById(id);
    }

    public TaskEntity createTask(TaskEntity newTaskEntity) {
        newTaskEntity.setStatus(TaskStatus.STARTED);
        return taskRepository.save(newTaskEntity);
    }


    public TaskEntity updateTask(Long id, String ownerUsername, String description, LocalDateTime deadline,TaskStatus status) {
        TaskEntity presentTask = findTaskById(id);
        UserEntity owner = findOwnerByUsername(ownerUsername);
        presentTask.setOwner(owner);
        presentTask.setDescription(description);
        presentTask.setDeadline(deadline);
        presentTask.setStatus(status);
        return taskRepository.save(presentTask);  // Saving the updated task
    }

    public UserEntity findOwnerByUsername(String username){
        UserEntity owner = userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));
        return owner;
    }

    public TaskEntity findTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("No task found with id: " + id));
    }

    public List<TaskEntity> getAllTasks(){
        List<TaskEntity> allTasks = taskRepository.findAll();
        return allTasks;
    }


}
