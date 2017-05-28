package com.infoshare;

public class Counter {
    int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void increment() {
        counter++;
    }

    public void reset() {
        counter = 0;
    }
}
