package com.kuttaib.kuttaib_api.task.repository;

import com.kuttaib.kuttaib_api.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository
        extends JpaRepository<Task, UUID> {
}