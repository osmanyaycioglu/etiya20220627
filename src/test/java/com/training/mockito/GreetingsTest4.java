package com.training.mockito;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GreetingsTest4 {
    private Greetings greetings;

    @Mock
    private HelloWorld helloWorld;

    @Spy
    private HelloWorld helloWorldSpy;

    @Captor
    private ArgumentCaptor<String> argumentCaptor;

    @BeforeEach
    void setUp() {
        greetings = new Greetings(helloWorld);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void greetings() {
        when(helloWorld.greet(ArgumentMatchers.any()))
                .thenReturn("mock test")
                .thenReturn("xyz")
                .thenReturn("abc");
        assertThat(greetings.greetings("osman"))
                .isEqualTo("mock test from Turkey");
        assertThat(greetings.greetings("mehmet"))
                .isEqualTo("xyz from Turkey");
        assertThat(greetings.greetings("ali"))
                .isEqualTo("abc from Turkey");
        verify(helloWorld,
               times(3)).greet(argumentCaptor.capture());
        List<String> allValues = argumentCaptor.getAllValues();
        assertThat(allValues.get(0)).isEqualTo("osman");
        assertThat(allValues.get(1)).isEqualTo("mehmet");
        assertThat(allValues.get(2)).isEqualTo("ali");
        System.out.println(allValues);
    }


}