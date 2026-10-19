package edu.course.lab02;

public class ProjectTask {
    private String id;
    private String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, TaskStatus status, int estimatedHours) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id не может быть null или пустым");
        }
        this.id = id;

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Название не может быть null или пустым");
        }
        this.title = title;

        if (status == null) {
            throw new IllegalArgumentException("Статус не может быть null");
        }
        this.status = status;

        if (estimatedHours < 0) {
            throw new IllegalArgumentException("Оценка времени не может быть отрицательным");
        }
        this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Новый статус не может быть null");
        }
        this.status = newStatus;
    }

    public boolean completeTask() {
        return this.status == TaskStatus.DONE;
    }

    public void gradeTask(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Оценка времени не может быть отрицательным или равна 0");
        }
        this.estimatedHours = this.estimatedHours + hours;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public int getEstimatedHours() {
        return this.estimatedHours;
    }
}
