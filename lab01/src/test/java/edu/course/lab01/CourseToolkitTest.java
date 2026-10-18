package edu.course.lab01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-8, 0, 2, 49})
    void isPrimeFalse(int result) {
        assertFalse(CourseToolkit.isPrime(result));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    void isPrimeTrue(int result) {
        assertTrue(CourseToolkit.isPrime(result));
    }

    @Test
    void isPalindrome() {
        boolean result1 = CourseToolkit.isPalindrome("лидер бредил");
        boolean result2 = CourseToolkit.isPalindrome("лидербредил");
        boolean result3 = CourseToolkit.isPalindrome("121");


        assertFalse(result1);
        assertTrue(result2);
        assertTrue(result3);
    }

    @Test
    void average() {
        double result1 = CourseToolkit.average(new int[] {1, 2, 3});
        int[] result2 = new int[0];
        double result3 = CourseToolkit.average(new int[] {-3, -3});

        assertEquals(2.0, result1);
        assertThrows(IllegalArgumentException.class, () -> {
            CourseToolkit.average(result2);
        });
        assertEquals(-3.0, result3);
    }
}
