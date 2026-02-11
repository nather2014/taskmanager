package com.example.taskmanager.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

     private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(TaskCreateRequest request) {
        Task task = new Task(request.getTitle());
        task.setCompleted(request.getCompleted() != null && request.getCompleted());
        return repository.save(task);
    }

    public Page<Task> getAll(Boolean completed, Pageable pageable) {
        if (completed == null) {
            return repository.findAll(pageable);
        }
        return repository.findByCompleted(completed, pageable);
    }

    public Task get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task update(Long id, TaskCreateRequest request) {
        Task existing = get(id);
        existing.setTitle(request.getTitle());
        existing.setCompleted(request.getCompleted() != null && request.getCompleted());
        return repository.save(existing);
    }

    public Task patch(Long id, TaskUpdateRequest update) {
        Task existing = get(id);
        if (update.getTitle() != null) {
            existing.setTitle(update.getTitle());
        }
        if (update.getCompleted() != null) {
            existing.setCompleted(update.getCompleted());
        }
        return repository.save(existing);
    }

    public Task markComplete(Long id) {
        Task existing = get(id);
        existing.setCompleted(true);
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        repository.deleteById(id);
    }
 
}
