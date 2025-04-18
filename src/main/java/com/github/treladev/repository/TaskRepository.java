package com.github.treladev.repository;

import com.github.treladev.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository interface for managing {@link TaskEntity} objects in the database.
 * Extends{@link JpaRepository} to priovide CRUD operations.
 *
 *
 */

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
}
