package com.infoshare;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bartman3000 on 28.05.17
 */
public class Calc {

    public int add(String input) {
        if (input.isEmpty()) return 0;

        int result = 0;
        List<String> inputStringArray =  Arrays.asList(input.split(","));
        List<Integer> numbers = inputStringArray.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (Integer number : numbers) result = result+number;
        return result;
    }
}
