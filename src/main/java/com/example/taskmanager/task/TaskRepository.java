package com.example.taskmanager.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    org.springframework.data.domain.Page<Task> findByCompleted(boolean completed, org.springframework.data.domain.Pageable pageable);
}
