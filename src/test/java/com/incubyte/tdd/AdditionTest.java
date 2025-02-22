package com.incubyte.tdd;

import com.incubyte.tdd.exception.NegativeNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionTest {

    Addition addition;
    @BeforeEach
    void setUp() {
        addition = new Addition();
    }
    @Test
    public void test_addEmptyString() {

        int result = addition.add("");

        assertEquals(0, result);
    }

    @Test
    public void test_singleNumberIsPassed() {
        int result = addition.add("1");

        assertEquals(1, result);
    }

    @Test
    public void test_addMultipleNumbers() {
        int result = addition.add("1,2");

        assertEquals(3, result);
    }
    
    @Test
    public void test_addNumberSeparatedByDelimiter() {
        int result = addition.add("1,2,\n3,4");

        assertEquals(10, result);
    }

    @Test
    public void testAddWithCustomDelimiter() {
        int result = addition.add("//;\n1;2;5;6");
        assertEquals(14, result);
    }

    @Test
    public void testAddWithNegativeNumber() {
        NegativeNumberException exception = assertThrows(NegativeNumberException.class, () -> {
            addition.add("//;\n1;2;-5;6;-3;-8;-4;-5");
        });
        assertTrue(exception.getMessage().contains("Negatives numbers not allowed: [-5, -3, -8, -4, -5]"));
    }
}
