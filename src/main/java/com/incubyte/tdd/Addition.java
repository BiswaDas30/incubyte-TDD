package com.incubyte.tdd;

public class Addition {

    public int add(String numbers) {
        int sum = 0;
        if (numbers.isEmpty()) {
            return 0;
        }
        sum += Integer.parseInt(numbers);
        return sum;
    }
}
