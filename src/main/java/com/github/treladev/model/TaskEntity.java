package com.github.treladev.model;

import com.github.treladev.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // many taskt to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    public TaskEntity(UserEntity owner, String description,LocalDateTime deadline) {
        this.owner = owner;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }


    public TaskEntity(UserEntity owner, String description,LocalDateTime deadline,TaskStatus taskStatus) {
        this.owner = owner;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }

}
