package com.example.taskmanager.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

  private final TaskService service;

  public TaskController(TaskService service) {
    this.service = service;
  }

  @PostMapping
  public TaskResponse create(@Valid @RequestBody TaskCreateRequest task) {
    return toResponse(service.create(task));
  }

  @GetMapping
  public Page<TaskResponse> getAll(
      @RequestParam(name = "completed", required = false) Boolean completed,
      @PageableDefault(size = 20) Pageable pageable) {
    return service.getAll(completed, pageable).map(this::toResponse);
  }

  @GetMapping("/{id}")
  public TaskResponse get(@PathVariable Long id) {
    return toResponse(service.get(id));
  }

  @PutMapping("/{id}")
  public TaskResponse update(@PathVariable Long id, @Valid @RequestBody TaskCreateRequest task) {
    return toResponse(service.update(id, task));
  }

  @PatchMapping("/{id}")
  public TaskResponse patch(@PathVariable Long id, @Valid @RequestBody TaskUpdateRequest update) {
    return toResponse(service.patch(id, update));
  }

  @PostMapping("/{id}/complete")
  public TaskResponse complete(@PathVariable Long id) {
    return toResponse(service.markComplete(id));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }

  private TaskResponse toResponse(Task task) {
    return new TaskResponse(task.getId(), task.getTitle(), task.isCompleted());
  }
}
