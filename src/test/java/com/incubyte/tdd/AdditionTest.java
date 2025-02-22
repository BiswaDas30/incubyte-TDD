package com.incubyte.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {

    @Test
    public void testAddEmptyString() {
        Addition addition = new Addition();
        int result = addition.add("");

        assertEquals(0, result);
    }

    @Test
    public void testSingleNumberIsPassed() {
        Addition addition = new Addition();
        int result = addition.add("1");

        assertEquals(1, result);
    }
}
