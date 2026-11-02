package edu.course.lab03.policy;

import edu.course.lab03.ProjectTask;
import edu.course.lab03.TaskStatus;

public class StatusPriorityPolicy implements PriorityPolicy {
    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("Задача не может быть null");
        }

        TaskStatus status = task.getStatus();

        if (status == null) {
            throw new IllegalArgumentException("Статус не может быть null");
        }

        return switch (status) {
            case IN_PROCESS -> 50;
            case NEW -> 10;
            case DONE -> 0;
        };
    }
}
