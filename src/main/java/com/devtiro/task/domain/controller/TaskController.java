package com.devtiro.task.domain.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devtiro.task.domain.CreateTaskRequest;
import com.devtiro.task.domain.dto.CreateTaskRequestDto;
import com.devtiro.task.domain.dto.TaskDto;
import com.devtiro.task.domain.entity.Task;
import com.devtiro.task.mapper.TaskMapper;
import com.devtiro.task.service.TaskService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping(path = "api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    
    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping 
    public ResponseEntity<TaskDto> createTask(
        @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ) {
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);

        TaskDto createTaskDto = taskMapper.toDto(task);

        return new ResponseEntity<>(createTaskDto, HttpStatus.CREATED);
    }
    
    @GetMapping 
    public ResponseEntity<List<TaskDto>> listTasks() {
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskDtos); 
    }
}
