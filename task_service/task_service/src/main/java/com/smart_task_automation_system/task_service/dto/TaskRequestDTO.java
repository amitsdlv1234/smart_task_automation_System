package com.smart_task_automation_system.task_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequestDTO {
    private String title;
    private String description;
    private String status;
    private String assignee;
    private LocalDateTime dueDate;
}
