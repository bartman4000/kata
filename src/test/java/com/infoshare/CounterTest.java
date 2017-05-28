package com.infoshare;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CounterTest {
    private static Counter counter;

    @BeforeClass
    public static void initialize() {
        counter = new Counter();
    }

    @After
    public void clean() {
        counter.reset();
    }

    @Test
    public void should_counter_equals_zero() {
        assertThat(counter.getCounter(), is(0));
    }

    @Test
    public void should_inrecement_couter_by_one() {
        counter.increment();

        assertThat(counter.getCounter(), is(1));
    }
}