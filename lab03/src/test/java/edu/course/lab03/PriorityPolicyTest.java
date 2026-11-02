package edu.course.lab03;

import edu.course.lab03.policy.EffortPriorityPolicy;
import edu.course.lab03.policy.PriorityPolicy;
import edu.course.lab03.policy.StatusPriorityPolicy;
import edu.course.lab03.policy.UrgencyPriorityPolicy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityPolicyTest {

    @Test
    void testEffortPolicyReturnsEstimatedHours() {
        PriorityPolicy policy = new EffortPriorityPolicy();
        ProjectTask task = new ProjectTask("1", "Разработка API", TaskStatus.NEW, 15);

        int priority = policy.calculatePriority(task);

        assertEquals(15, priority, "Приоритет должен быть равен количеству оцененных часов");
    }

    @Test
    void testEffortPolicyWithZeroHours() {
        PriorityPolicy policy = new EffortPriorityPolicy();
        ProjectTask task = new ProjectTask("2", "Мелкий фикс", TaskStatus.NEW, 0);

        int priority = policy.calculatePriority(task);

        assertEquals(0, priority, "Приоритет для задачи с 0 часов должен быть равен 0");
    }

    @Test
    void testStatusPolicyInProcessIsHigherThanNew() {
        PriorityPolicy policy = new StatusPriorityPolicy();
        ProjectTask inProcessTask = new ProjectTask("3", "Выполнение задач", TaskStatus.IN_PROCESS, 5);
        ProjectTask newTask = new ProjectTask("4", "Написать план", TaskStatus.NEW, 5);

        int inProcessPriority = policy.calculatePriority(inProcessTask);
        int newPriority = policy.calculatePriority(newTask);

        assertTrue(inProcessPriority > newPriority,
                "Задача в процессе должна иметь приоритет выше, чем новая задача");
    }

    @Test
    void testStatusPolicyDoneHasZeroPriority() {
        PriorityPolicy policy = new StatusPriorityPolicy();
        ProjectTask doneTask = new ProjectTask("5", "Сделать тест", TaskStatus.DONE, 40);

        int priority = policy.calculatePriority(doneTask);

        assertEquals(0, priority, "Выполненная задача должна всегда иметь приоритет 0");
    }

    @Test
    void testUrgencyPolicyDoublesHoursForNewTasks() {
        PriorityPolicy policy = new UrgencyPriorityPolicy();
        ProjectTask newTask = new ProjectTask("6", "Новая задача", TaskStatus.NEW, 10);

        int priority = policy.calculatePriority(newTask);

        assertEquals(20, priority, "Для новых задач оценка времени должна удваиваться");
    }

    @Test
    void testUrgencyPolicyReturnsStandardHoursForInProcessTasks() {
        PriorityPolicy policy = new UrgencyPriorityPolicy();
        ProjectTask inProcessTask = new ProjectTask("7", "Задача в процессе", TaskStatus.IN_PROCESS, 10);

        int priority = policy.calculatePriority(inProcessTask);

        assertEquals(10, priority, "Для задач в процессе приоритет должен быть равен базовым часам");
    }

    @Test
    void testPolicyReplacementInPrioritizer() {
        ProjectTask shortInProcessTask = new ProjectTask("8", "Фикс бага", TaskStatus.IN_PROCESS, 2);
        ProjectTask longNewTask = new ProjectTask("9", "Проектирование БД", TaskStatus.NEW, 20);

        TaskPrioritizer statusPrioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        ProjectTask importantByStatus = statusPrioritizer.getMoreImportant(shortInProcessTask, longNewTask);
        assertEquals(shortInProcessTask, importantByStatus, "По статусу важнее, чем короткая задача 'в процессе'");

        TaskPrioritizer effortPrioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        ProjectTask importantByEffort = effortPrioritizer.getMoreImportant(shortInProcessTask, longNewTask);
        assertEquals(longNewTask, importantByEffort, "По трудозатратам важнее, чем длинная новая задача");
    }
}
