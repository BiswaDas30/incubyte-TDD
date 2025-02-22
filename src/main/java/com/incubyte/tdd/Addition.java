package com.incubyte.tdd;

import com.incubyte.tdd.exception.NegativeNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Addition {

    private static final String DEFAULT_DELIMITER = ",|\n";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*?)\n(.*)");
    List<Integer> negativeNumbers = new ArrayList<>();


    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        if (numbers.startsWith("//")) {
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(numbers);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            }
        }

        String[] numbersArray = splitNumbers(numbers, delimiter);

        int sum = calculateSum(numbersArray, negativeNumbers);

        if (!negativeNumbers.isEmpty()) {
            throw new NegativeNumberException("Negatives numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }

    private String[] splitNumbers(String numbers, String delimiter) {
        return Arrays.stream(numbers.split(delimiter))
                .filter(num -> !num.isEmpty())
                .toArray(String[]::new);
    }

    private int calculateSum(String[] numbersArray, List<Integer> negativeNumbers) {
        int sum = 0;
        for (String num : numbersArray) {
            int parsedNum = Integer.parseInt(num);
            if (parsedNum < 0) {
                negativeNumbers.add(parsedNum);
            }
            sum += parsedNum;
        }
        return sum;
    }
}