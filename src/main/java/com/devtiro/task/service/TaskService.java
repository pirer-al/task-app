package com.devtiro.task.service;

import java.util.List;

import com.devtiro.task.domain.CreateTaskRequest;
import com.devtiro.task.domain.entity.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();
}
