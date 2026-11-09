package edu.course.lab03.policy;

import edu.course.lab03.ProjectTask;
import edu.course.lab03.TaskStatus;

public class UrgencyPriorityPolicy implements PriorityPolicy {
    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("Задача не может быть null");
        }

        if (task.getStatus() == TaskStatus.DONE) {
            return 0;
        }

        if (task.getStatus() == TaskStatus.NEW) {
            return task.getEstimatedHours() * 2;
        }

        return task.getEstimatedHours();
    }
}
