package com.training.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositiveCalculatorTest {
    private PositiveCalculator positiveCalculator;

    @BeforeEach
    void setUp() {
        positiveCalculator = new PositiveCalculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAdd() {
        assertEquals(10,
                     positiveCalculator.add(7,
                                            3));
        assertEquals(110,
                     positiveCalculator.add(75,
                                            35));
        assertEquals(17,
                     positiveCalculator.add(9,
                                            8));
        assertThrows(IllegalArgumentException.class,
                     () -> positiveCalculator.add(-9,
                                                  8));
        assertThrows(IllegalArgumentException.class,
                     () -> positiveCalculator.add(9,
                                                  -8));
        assertThrows(IllegalArgumentException.class,
                     () -> positiveCalculator.add(-9,
                                                  -8));
        assertThrows(IllegalArgumentException.class,
                     () -> positiveCalculator.add(Integer.MAX_VALUE - 10,
                                                  Integer.MAX_VALUE - 10));
    }

    @Test
    void testSubs() {
        assertEquals(4,
                     positiveCalculator.subs(7,
                                            3));
        assertEquals(40,
                     positiveCalculator.subs(75,
                                            35));
        assertEquals(1,
                     positiveCalculator.subs(9,
                                            8));
        assertThrows(IllegalArgumentException.class,
                     () -> positiveCalculator.subs(-9,
                                                  8));
        assertEquals(17,
                     positiveCalculator.subs(9,
                                            -8));
        assertThrows(IllegalArgumentException.class,
                     () -> positiveCalculator.subs(-9,
                                                  -8));
        assertThrows(IllegalArgumentException.class,
                     () -> positiveCalculator.subs(Integer.MAX_VALUE - 20,
                                                  Integer.MAX_VALUE - 10));
    }

}