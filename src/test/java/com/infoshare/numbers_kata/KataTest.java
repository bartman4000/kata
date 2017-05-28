package com.infoshare.numbers_kata;

import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by bartman3000 on 19.03.17.
 */
public class KataTest {


    @Test
    public void one_should_be_odd()
    {
        assertThat(isOdd(1), is(true));
    }

    @Test
    public void two_should_not_be_odd()
    {
        assertThat(isOdd(2), is(false));
    }

    @Test
    public void three_should_be_odd()
    {
        assertThat(isOdd(3), is(true));
    }

    @Test
    public void minus_three_should_be_odd()
    {
        assertThat(isOdd(-3), is(true));
    }

    @Test(expected = NullPointerException.class)
    public void null_should_throw_exception()
    {
        assertThat(isOdd(null), is(true));
    }

    @Test
    public void zero_should_not_be_odd()
    {
        assertThat(isOdd(0), is(false));
    }

    @Test
    public void integer_MAX_VALUE_be_odd()
    {
        assertThat(isOdd(Integer.MAX_VALUE), is(true));
    }

    @Test
    public void integer_MIN_VALUE_should_not_be_odd()
    {
        assertThat(isOdd(Integer.MIN_VALUE), is(false));
    }

    private boolean isOdd(Integer i)
    {
        return i % 2 != 0;
    }

}