package com.training.mockito;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GreetingsTest3 {
    private Greetings greetings;

    @Mock
    private HelloWorld helloWorld;

    @Spy
    private HelloWorld helloWorldSpy;


    @BeforeEach
    void setUp() {
        greetings = new Greetings(helloWorld);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void greetings() {
        NameHolder nameHolder = new NameHolder();
        nameHolder.add("osman");
        nameHolder.add("ali");
        nameHolder.add("veli");
        Assertions.assertThat(greetings.greetingsToAll(nameHolder))
                  .isEqualTo("I greet all osman ali veli .");
        NameHolder spyNameHolder = Mockito.spy(nameHolder);
        spyNameHolder.reset();
        when(spyNameHolder.getName()).thenReturn("mehmet")
                                     .thenReturn("ayşe")
                                     .thenReturn("fatma");
        Assertions.assertThat(greetings.greetingsToAll(spyNameHolder))
                  .isEqualTo("I greet all mehmet ayşe fatma .");
        verify(spyNameHolder,
               atLeast(3)).getName();
        verify(spyNameHolder,
               atLeast(1)).size();
        verify(spyNameHolder,
               atLeast(1)).reset();

        spyNameHolder.printList();

    }

    @Test
    void greetings2() {
        NameHolder nameHolder = new NameHolder();
        nameHolder.add("osman");
        nameHolder.add("ali");
        nameHolder.add("veli");
        NameHolder spyNameHolder = Mockito.spy(nameHolder);
        NameHolder mockNameHolder = mock(NameHolder.class);
        greetings.proc(spyNameHolder);
        verify(spyNameHolder,
               times(3)).getName();
        verify(spyNameHolder,
               atLeast(1)).size();
        verify(spyNameHolder,
               times(1)).reset();
        spyNameHolder.printList();

    }


}