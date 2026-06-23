package com.david.todoapp.dto;

import com.david.todoapp.model.TaskStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {

    @NotBlank(message = "el titulo no puede estar vacio")
    @Size(max = 100)
    private String title;

    private String description;
    private TaskStatus status;

}
