package com.example.taskmanager.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class TaskTestRunner implements CommandLineRunner {
    private final TaskRepository repo;

    TaskTestRunner(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        repo.save(new Task("from java"));
        System.out.println(repo.findAll());
    }
}