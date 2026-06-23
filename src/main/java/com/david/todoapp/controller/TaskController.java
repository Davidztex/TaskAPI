package com.david.todoapp.controller;


import com.david.todoapp.dto.TaskRequest;
import com.david.todoapp.dto.TaskResponse;
import com.david.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);
    }

    @GetMapping("/getbyid")
    public TaskResponse getTaskById(@RequestParam UUID id) {
        return taskService.getById(id);
    }

    @GetMapping("/getalltasks")
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTask();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        taskService.deleteById(id);
    }

    @PutMapping("{id}")
    public TaskResponse updateTask(@PathVariable UUID id, @RequestBody TaskRequest taskRequest) {
        return taskService.updateTask(id, taskRequest);
    }
}
