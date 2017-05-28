package com.infoshare;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bartman3000 on 28.05.17.
 */
public class CalcTest {

    private static Calc calc;

    @Before
    public void setUp() throws Exception {
        calc = new Calc();
    }

    @Test
    public void emptyInput() {
//        Given
        String input = "";
//        When
        int result = calc.add(input);
//        Then
        int expected = 0;
        assertEquals(result, expected);
    }

    @Test
    public void twoStringNumbersInput() {
//        Given
        String input1 = "1,2";
        String input2 = "0,0";
//        When
        int result1 = calc.add(input1);
        int result2 = calc.add(input2);
//        Then
        assertEquals(3,result1);
        assertEquals(0,result2);
    }

    @Test
    public void fewStringNumbersInput() {
//        Given
        String input1 = "1,2,1,2";
        String input2 = "0,0,0,1,1,1";
//        When
        int result1 = calc.add(input1);
        int result2 = calc.add(input2);
//        Then
        assertEquals(6,result1);
        assertEquals(3,result2);
    }

    @Test
    public void inputWithNewLineSplit() {
//        Given
        String input = "1\n2\n3";
//        When
        int result1 = calc.add(input);
//        Then
        assertEquals(6,result1);
    }

    @Test
    public void inputWithEmptySpaceDelimiter() {
//        Given
        String input = "1 2 3";
//        When
        int result1 = calc.add(input);
//        Then
        assertEquals(6,result1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ThrowExceptionWhenNumberisNegative() {
//        Given
        String input = "1,-2,3";
//        When
        int result = calc.add(input);
    }

    @Test
    public void ignoreOvetThousandNumbers() {
//        Given
        String input = "1,1003,3";
//        When
        int result1 = calc.add(input);
//        Then
        assertEquals(4,result1);
    }

}