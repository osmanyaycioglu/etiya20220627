package com.training.mockito;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GreetingsTest2 {
    private Greetings greetings;

    @Mock
    private HelloWorld helloWorld;

    @BeforeEach
    void setUp() {
        greetings = new Greetings(helloWorld);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void greetings() {
        Mockito.when(helloWorld.hello())
               .thenReturn("mock test")
               .thenReturn("xyz")
               .thenReturn("abc");
        Assertions.assertThat(greetings.greetings())
                  .isEqualTo("mock test from Turkey");
        Assertions.assertThat(greetings.greetings())
                  .isEqualTo("xyz from Turkey");
        Assertions.assertThat(greetings.greetings())
                  .isEqualTo("abc from Turkey");
    }

    @Test
    void greetings2() {
        Mockito.doReturn("mock test")
               .when(helloWorld)
               .hello();
        Assertions.assertThat(greetings.greetings())
                  .isEqualTo("mock test from Turkey");
    }

    @Test
    void greetings3() {
        Assertions.assertThat(greetings.greetings())
                  .isEqualTo("mock test from Turkey");
    }

    @Test
    void testGreetings() {
        Mockito.when(helloWorld.greet("osman"))
               .thenReturn("Greet osman");
        Assertions.assertThat(greetings.greetings("osman"))
                  .isEqualTo("Greet osman from Turkey");
        Mockito.when(helloWorld.greet(ArgumentMatchers.anyString()))
               .thenReturn("Greet xyz");
        Assertions.assertThat(greetings.greetings("sdhjkfkb sd"))
                  .isEqualTo("Greet xyz from Turkey");
    }

    @Test
    void testGreetings1() {
        Assertions.assertThat(greetings.greetings("osman",
                                                  "yay"))
                  .isEqualTo("Test hello osman yay from Turkey");
    }
}