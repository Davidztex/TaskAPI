package com.david.todoapp.service;


import com.david.todoapp.dto.TaskRequest;
import com.david.todoapp.dto.TaskResponse;
import com.david.todoapp.model.Task;
import com.david.todoapp.repository.TaskRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse createTask(TaskRequest taskRequest) {

        Task task = new Task();

        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());

        Task saved = taskRepository.save(task);

        return mapToResponse(saved);

    }



    public TaskResponse getById(UUID id) {

        Optional<Task> task = taskRepository.findById(id);

        assert task.orElse(null) != null;
        return mapToResponse(task.orElse(null));


    }

    public List<TaskResponse> getAllTask() {
        List<Task> tasks = taskRepository.findAll();

        List<TaskResponse> taskResponseList = new ArrayList<>();
        for (Task task : tasks) {
            taskResponseList.add(mapToResponse(task));
        }

        return taskResponseList;
    }

    public void deleteById(UUID id) {

        System.out.println("Deleting task with id: " + id);
        taskRepository.deleteById(id);

    }

    public TaskResponse updateTask(UUID id, TaskRequest taskRequest) {

        Task task = taskRepository.findById(id).orElse(null);

        assert task != null;
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());
        Task saved = taskRepository.save(task);
        
        return mapToResponse(saved);
        


    }

    private TaskResponse mapToResponse(Task saved) {

        TaskResponse response = new TaskResponse();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setStatus(saved.getStatus());
        response.setCreatedAt(saved.getCreatedAt());

        return response;
    }
}
