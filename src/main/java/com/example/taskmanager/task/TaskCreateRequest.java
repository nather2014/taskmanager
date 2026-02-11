package com.example.taskmanager.task;

import jakarta.validation.constraints.NotBlank;

public class TaskCreateRequest {
    @NotBlank
    private String title;
    private Boolean completed;

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
