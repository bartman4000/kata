package com.infoshare.string_calculator_kata;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by bartman3000 on 19.03.17.
 */
public class KataTest {

    private static Kata kata;

    @BeforeClass
    public static void initialize() {
        kata = new Kata();
    }

    @Test
    public void should_return_zero_for_empty_string() {
        assertEquals(0, kata.Add(""));
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_for_some_bullshit_instead_of_numbers() {
        kata.Add("some,bullshit");
        kata.Add("some\nbullshit");
    }

    @Test
    public void should_return_3_for_3() {
        assertEquals(3, kata.Add("3"));
    }

    @Test
    public void should_return_5_for_3_and_2() {
        assertEquals(5, kata.Add("2,3"));
        assertEquals(5, kata.Add("2\n3"));
    }

    @Test(expected = IllegalStateException.class)
    public void should_throw_exception_for_some_negative_numbers() {
        kata.Add("-6,2");
    }

    @Test
    public void should_numbers_bigger_than_1000_be_ignored() {
        assertEquals(2, kata.Add("2,1001"));
        assertEquals(2, kata.Add("2\n1001"));
    }

    @Test
    public void should_support_different_delimiters() {
        assertEquals(3, kata.Add("//;\n1;2"));
    }

    @Test
    public void should_support_any_length_delimiters() {
        assertEquals(6, kata.Add("//[***]\n1***2***3"));
    }

    @Test
    public void should_support_multiple_delimiters() {
        assertEquals(6, kata.Add("//[**][%%]\n1**2%%3"));
    }
}