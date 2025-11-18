package com.smart_task_automation_system.task_service.repositary;

import com.smart_task_automation_system.task_service.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByStatus(String status);
}
