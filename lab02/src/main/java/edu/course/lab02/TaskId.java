package edu.course.lab02;

public record TaskId(String id) {

    public TaskId {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id не может быть null или пустым");
        }
    }
}
