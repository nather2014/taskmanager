package com.example.taskmanager.task;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

     private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(Task task) {
        task.setId(null); // ensure new entity
        return repository.save(task);
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found: " + id));
    }

    public Task update(Long id, Task task) {
        Task existing = get(id);
        existing.setTitle(task.getTitle());
        existing.setCompleted(task.isCompleted());
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Task not found: " + id);
        }
        repository.deleteById(id);
    }
 
}
