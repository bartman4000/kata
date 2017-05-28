package com.infoshare.multiplier_exercise;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bartman3000 on 18.03.17.
 */
public class MultiplierTest {

    private Multiplier multiplier = new Multiplier();

    @Test
    public void should_multiple_two_numbers()
    {
        //when
        int actual = multiplier.execute(4,5);

        //then
        assertEquals(20, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception()
    {
        //when
        int actual = multiplier.execute(400,5);
    }

}