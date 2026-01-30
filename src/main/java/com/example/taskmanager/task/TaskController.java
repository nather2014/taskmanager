package com.example.taskmanager.task;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/tasks")
public class TaskController {

  private final TaskService service;

  public TaskController(TaskService service) {
    this.service = service;
  }

  @PostMapping
  public Task create(@RequestBody Task task) {
    return service.create(task);
  }

  @GetMapping
  public List<Task> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public Task get(@PathVariable Long id) {
    return service.get(id);
  }

  @PutMapping("/{id}")
  public Task update(@PathVariable Long id, @RequestBody Task task) {
    return service.update(id, task);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
