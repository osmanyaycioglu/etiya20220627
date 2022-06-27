package com.training.calculator;

public class PositiveCalculator {

    public int add(int val1,
                   int val2) {
        if (val1 < 0 || val2 < 0) {
            throw new IllegalArgumentException("value lar positif olamalı");
        }
        int result = val1 + val2;
        if (result < 0) {
            throw new IllegalArgumentException("value lar çok büyük");
        }
        return result;
    }

    public int subs(int val1,
                    int val2) {
        int result = val1 - val2;
        if (result < 0) {
            throw new IllegalArgumentException("sonuç eksi olamaz");
        }
        return result;
    }

}
