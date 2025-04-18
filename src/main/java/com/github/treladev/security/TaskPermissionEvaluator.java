package com.github.treladev.security;

import com.github.treladev.model.TaskEntity;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Custom permission evaluator for task-related authorization checks
 */
@Component
public class TaskPermissionEvaluator implements PermissionEvaluator {

    /**
     * Checks permission for a specific task object
     * @param authentication Current user authentication
     * @param targetDomainObject The task object being checked
     * @param permission The required permission/role
     * @return true if user has permission, false otherwise
     */
    @Override
    public boolean hasPermission(Authentication authentication,
                                 Object targetDomainObject,
                                 Object permission) {
        TaskEntity task = (TaskEntity) targetDomainObject;
        String requiredRole = (String) permission;

        // Check if user has the required role
        boolean hasRole = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals(requiredRole));

        // Check if user is the task owner
        boolean isOwner = task.getOwner().getUsername().equals(authentication.getName());

        return hasRole || isOwner;
    }

    /**
     * Not implemented - checks permission by ID and type
     */
    @Override
    public boolean hasPermission(Authentication authentication,
                                 Serializable targetId,
                                 String targetType,
                                 Object permission) {
        return false;
    }
}