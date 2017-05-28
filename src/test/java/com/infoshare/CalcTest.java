package com.infoshare;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
    public void should_return_3_for_1_and_2() {
        assertEquals(3, calc.Add("1,2"));
    }

//    @Test
//    public void should_return_0_for_empty_string() {
//        assertEquals(0, calc.Add());
//    }
//
//    @Test
//    public void should_count_any_numbers() {
//        assertEquals(16, calc.Add("2,3,4,7"));
//    }


}