package com.smart_task_automation_system.task_service.service;

import com.smart_task_automation_system.task_service.dto.TaskRequestDTO;
import com.smart_task_automation_system.task_service.dto.TaskResponseDTO;
import com.smart_task_automation_system.task_service.entity.Task;
import com.smart_task_automation_system.task_service.exception.TaskNotFoundException;
import com.smart_task_automation_system.task_service.repositary.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskResponseDTO> getAll(String status) {
        List<Task> tasks = (status != null)
                ? taskRepository.findByStatus(status)
                : taskRepository.findAll();

        return tasks.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public TaskResponseDTO getById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));

        return toDTO(task);
    }

    public TaskResponseDTO create(TaskRequestDTO dto) {
        Task task = toEntity(dto);
        return toDTO(taskRepository.save(task));
    }

    public TaskResponseDTO update(Long id, TaskRequestDTO dto) {
        Task existing = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setStatus(dto.getStatus());
        existing.setAssignee(dto.getAssignee());
        existing.setDueDate(dto.getDueDate());

        return toDTO(taskRepository.save(existing));
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    private TaskResponseDTO toDTO(Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .assignee(task.getAssignee())
                .dueDate(task.getDueDate())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }

    private Task toEntity(TaskRequestDTO dto) {
        return Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .assignee(dto.getAssignee())
                .dueDate(dto.getDueDate())
                .build();
    }
}
