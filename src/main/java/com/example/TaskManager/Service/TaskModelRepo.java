package com.example.TaskManager.Service;

import com.example.TaskManager.Model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskModelRepo extends JpaRepository<TaskModel, Long> {
}
