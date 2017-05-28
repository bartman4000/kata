package com.infoshare.multiplier_exercise;

public class Multiplier {

    public int execute(int a, int b) {
        if (a > 99 || b > 99) {
            throw new IllegalArgumentException("Numbers should be less than 100");
        }
        return a * b;
    }
}
