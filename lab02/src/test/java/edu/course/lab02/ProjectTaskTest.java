package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTaskTest {

    @Test
    public void TrueCreateTask() {
        ProjectTask task = new ProjectTask("1", "Написать тесты", TaskStatus.NEW, 12);

        assertEquals("1", task.getId());
        assertEquals("Написать тесты", task.getTitle());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertEquals(12, task.getEstimatedHours());
        assertFalse(task.completeTask(), "Задача должна быть активной");
    }

    @Test
    public void IdNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProjectTask(null, "Проверить тесты", TaskStatus.IN_PROCESS, 6);
        }, "Id не может быть null");
    }

    @Test
    public void IdNotEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProjectTask("", "Проверить тесты", TaskStatus.IN_PROCESS, 6);
        }, "Id не может быть пустым");
    }

    @Test
    public void TitleNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProjectTask("2", null, TaskStatus.IN_PROCESS, 6);
        }, "Название не может быть null");
    }

    @Test
    public void TitleNotEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProjectTask("2", "", TaskStatus.IN_PROCESS, 6);
        }, "Название не может быть пустым");
    }

    @Test
    public void StatusNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProjectTask("2", "Проверить тесты", null, 6);
        }, "Статус не может быть null");
    }

    @Test
    public void EstimatedHoursNotNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProjectTask("2", "Проверить тесты", TaskStatus.IN_PROCESS, -1);
        }, "Оценка времени не может быть отрицательным");
    }

    @Test
    public void ChangeStatusNotNull() {
        ProjectTask task = new ProjectTask("2", "Проверить тесты", TaskStatus.IN_PROCESS, 6);
        assertThrows(IllegalArgumentException.class, () -> {
            task.changeStatus(null);
        }, "Нельзя изменить статус на null");
    }

    @Test
    public void EstimatedHoursPositive() {
        ProjectTask task = new ProjectTask("2", "Проверить тесты", TaskStatus.IN_PROCESS, 6);

        assertThrows(IllegalArgumentException.class, () -> {
            task.gradeTask(0);
        }, "Нельзя добавить 0 часов");

        assertThrows(IllegalArgumentException.class, () -> {
            task.gradeTask(-3);
        }, "Нельзя добавить отрицательное количество часов");
    }

    @Test
    public void StateNotModifiedUncontrolled() {
        ProjectTask task = new ProjectTask("3", "Изменить статус", TaskStatus.NEW, 4);

        task.changeStatus(TaskStatus.IN_PROCESS);
        task.gradeTask(2);

        assertEquals(TaskStatus.IN_PROCESS, task.getStatus());
        assertEquals(6, task.getEstimatedHours());

        int hours = task.getEstimatedHours();
        hours = 322;

        assertEquals(6, task.getEstimatedHours());

        assertFalse(task.completeTask());
        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.completeTask());
    }


}
