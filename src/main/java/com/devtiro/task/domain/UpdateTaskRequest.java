package com.devtiro.task.domain;

import java.time.LocalDate;

import com.devtiro.task.domain.entity.TaskPriority;
import com.devtiro.task.domain.entity.TaskStatus;

public record UpdateTaskRequest(
    String title, 
    String description,
    LocalDate dueDate,
    TaskStatus status,
    TaskPriority priority
) {
    
}
