package com.incubyte.tdd;

public class Addition {

    public int add(String numbers) {
        int sum = 0;
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numbersArray = numbers.split(",");

        for(String num : numbersArray){
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
