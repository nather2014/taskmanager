package com.example.taskmanager.config;

import java.time.Instant;
import java.util.List;

class ApiError {
    private final Instant timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;
    private final List<FieldIssue> fields;

    ApiError(Instant timestamp, int status, String error, String message, String path, List<FieldIssue> fields) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fields = fields;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public List<FieldIssue> getFields() {
        return fields;
    }

    static class FieldIssue {
        private final String field;
        private final String message;

        FieldIssue(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }
}
