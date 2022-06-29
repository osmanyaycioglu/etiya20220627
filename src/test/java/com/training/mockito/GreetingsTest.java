package com.training.mockito;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest {
    private Greetings greetings;

    @BeforeEach
    void setUp() {
        greetings = new Greetings(new HelloWorldProxy());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void greetings() {
        Assertions.assertThat(greetings.greetings())
                  .isEqualTo("Test data from Turkey");
    }

    @Test
    void testGreetings() {
        Assertions.assertThat(greetings.greetings("osman"))
                  .isEqualTo("Test greet osman from Turkey");

    }

    @Test
    void testGreetings1() {
        Assertions.assertThat(greetings.greetings("osman","yay"))
                  .isEqualTo("Test hello osman yay from Turkey");
    }
}