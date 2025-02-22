package com.incubyte.tdd;

import com.incubyte.tdd.exception.NegativeNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Addition {

    public int add(String numbers) {
        int sum = 0;
        String[] numbersArray;
        List<Integer> negativeNumbers = new ArrayList<>();
        if (numbers.isEmpty()) {
            return 0;
        }

        //Default delimiter
        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*?)\n(.*)").matcher(numbers); //Extracting custom delimiter
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            }
        }

        numbersArray = Arrays.stream(numbers.split(delimiter))
                .filter(num -> !num.isEmpty())
                .toArray(String[]::new);

        for(String num : numbersArray){
            int parsedNum = Integer.parseInt(num);
            if(parsedNum < 0){
                throw new NegativeNumberException("Negatives not allowed");
            }
            sum += parsedNum;
        }
        return sum;
    }
}
