package com.incubyte.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {

    @Test
    public void test_addEmptyString() {
        Addition addition = new Addition();
        int result = addition.add("");

        assertEquals(0, result);
    }

    @Test
    public void test_singleNumberIsPassed() {
        Addition addition = new Addition();
        int result = addition.add("1");

        assertEquals(1, result);
    }

    @Test
    public void test_addMultipleNumbers() {
        Addition addition = new Addition();
        int result = addition.add("1,2");

        assertEquals(3, result);
    }
    
    @Test
    public void test_addNumberSeparatedByDelimiter() {
        Addition addition = new Addition();
        int result = addition.add("1;2|3\n,4\n");

        assertEquals(10, result);
    }
}
