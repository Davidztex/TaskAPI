package com.david.todoapp.dto;

import com.david.todoapp.model.Task;
import com.david.todoapp.model.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class TaskResponse {


    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;


}
