package edu.course.lab04;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class IssueRegistryTest {

    @Test
    void testRegistryStandardOperations() {
        IssueRegistry registry = new IssueRegistry();
        IssueId key1 = new IssueId("Да", 42);
        IssueId key2 = new IssueId("Да", 42);
        ProjectTask task1 = new ProjectTask("1", "Задача 1", TaskStatus.NEW, 4);
        ProjectTask task2 = new ProjectTask("2", "Задача 2", TaskStatus.IN_PROCESS, 6);

        registry.put(key1, task1);
        assertEquals(task1, registry.get(key2));

        registry.put(key2, task2);
        assertEquals(1, registry.size());
        assertEquals(task2, registry.get(key1));

        assertTrue(registry.contains(key1));
        ProjectTask removed = registry.remove(key1);
        assertEquals(task2, removed);
        assertFalse(registry.contains(key1));
        assertEquals(0, registry.size());
    }

    @Test
    void testEqualsWithNullAndDifferentType() {
        IssueId key = new IssueId("Веб", 10);

        assertNotEquals(null, key);
        assertNotEquals("Строка", key);
    }

    @Test
    void testIntentionallyCollisionBehavior() {
        Map<CollisionKey, String> map = new HashMap<>();
        CollisionKey k1 = new CollisionKey("Задача 1");
        CollisionKey k2 = new CollisionKey("Задача 2");

        assertEquals(k1.hashCode(), k2.hashCode());
        assertNotEquals(k1, k2);

        map.put(k1, "А");
        map.put(k2, "Б");

        assertEquals(2, map.size());
        assertEquals("А", map.get(k1));
        assertEquals("Б", map.get(k2));
    }

    @Test
    void testMutableKeyProblemDemonstration() {
        Map<MutableTestKey, String> map = new HashMap<>();
        MutableTestKey key = new MutableTestKey(500);

        map.put(key, "Информация");

        key.setId(600);

        assertNull(map.get(key));
        assertFalse(map.containsKey(key));
    }
}
