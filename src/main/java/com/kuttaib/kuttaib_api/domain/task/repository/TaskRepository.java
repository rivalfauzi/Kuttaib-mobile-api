package com.kuttaib.kuttaib_api.domain.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuttaib.kuttaib_api.domain.task.entity.Task;

import java.util.UUID;

public interface TaskRepository
        extends JpaRepository<Task, UUID> {
}