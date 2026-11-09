package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    void testEqualsAndHashCodeContract() {
        Book book1 = new Book("978-5-93286-216-2", "Война и мир");
        Book book2 = new Book("978-5-93286-216-2", "Философия Java");
        Book book3 = new Book("978-5-17-080115-2", "1984");

        assertEquals(book1, book2);
        assertNotEquals(book1, book3);

        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    void testHashMapBehaviorWithLogicalEquals() {
        Map<Book, String> library = new HashMap<>();
        Book book1 = new Book("978-5-93286-216-2", "О дивный новый мир");

        library.put(book1, "Полка А4");

        Book book2 = new Book("978-5-93286-216-2", "О дивный новый мир - копия");

        assertTrue(library.containsKey(book2));
        assertEquals("Полка А4", library.get(book2));
    }
}
