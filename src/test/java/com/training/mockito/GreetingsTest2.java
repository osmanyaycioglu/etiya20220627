package com.training.mockito;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GreetingsTest2 {
    // @InjectMocks
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
        when(helloWorld.hello())
                .thenReturn("mock test")
                .thenReturn("xyz")
                .thenReturn("abc");
        assertThat(greetings.greetings())
                .isEqualTo("mock test from Turkey");
        assertThat(greetings.greetings())
                .isEqualTo("xyz from Turkey");
        assertThat(greetings.greetings())
                .isEqualTo("abc from Turkey");
    }

    @Test
    void greetings2() {
        Mockito.doReturn("mock test")
               .when(helloWorld)
               .hello();
        assertThat(greetings.greetings())
                .isEqualTo("mock test from Turkey");
    }

    @Test
    void greetings3() {
        assertThat(greetings.greetings())
                .isEqualTo("mock test from Turkey");
    }


    @Test
    void testGreetings2() {
        when(helloWorld.greet("osmanyay"))
                .thenThrow(new IllegalArgumentException("7 den büyük olamaz"));
        assertThatThrownBy(() -> greetings.greetings("osmanyay"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("7 den büyük olamaz");
    }

    @Test
    void testGreetings3() {
        when(helloWorld.greet("osmanyay"))
                .thenThrow(new IllegalArgumentException("7 den büyük olamaz"));
        assertThat(greetings.greetings2("osmanyay"))
                .startsWith("Error");
    }

    @Test
    void testGreetings4() {
        when(helloWorld.greet("osmany"))
                .thenReturn("osman");
        assertThat(greetings.greetings2("osmany"))
                .isEqualTo("osman from Turkey");
    }

    @Test
    void testGreetings5() {
        when(helloWorld.greet(ArgumentMatchers.any()))
                .thenAnswer(v1 -> {
                    String arg = v1.getArgument(0);
                    if (arg.length() > 5) {
                        arg = arg.substring(0,
                                            5);
                    }
                    return arg;
                });
        assertThat(greetings.greetings2("osmany"))
                .isEqualTo("osman from Turkey");
        assertThat(greetings.greetings2("mehmet"))
                .isEqualTo("mehme from Turkey");
    }

    @Test
    void testGreetings6() {
        when(helloWorld.greet(ArgumentMatchers.any()))
                .thenAnswer(GreetingsTest2::HelloWorldGreetWith5Check);
        assertThat(greetings.greetings2("osmany"))
                .isEqualTo("osman from Turkey");
        assertThat(greetings.greetings2("mehmet"))
                .isEqualTo("mehme from Turkey");

    }

    public static Object HelloWorldGreetWith5Check(InvocationOnMock invocation) {
        String arg = invocation.getArgument(0);
        if (arg.length() > 5) {
            arg = arg.substring(0,
                                5);
        }
        return arg;
    }

    @Test
    void testGreetings7() {
        when(helloWorld.greet("osmany"))
                .thenReturn("osman");
        assertThat(greetings.greetings2("osmany"))
                .isEqualTo("osman from Turkey");

        Mockito.verify(helloWorld,
                       Mockito.atLeast(1))
               .greet("osmany");

        Mockito.verify(helloWorld,
                       Mockito.times(1))
               .greet("osmany");

        Mockito.verify(helloWorld,
                       Mockito.atLeast(2))
               .greet(ArgumentMatchers.any());
        Mockito.verify(helloWorld,
                       Mockito.atMost(3))
               .greet(ArgumentMatchers.any());
        Mockito.verify(helloWorld,
                       Mockito.times(2))
               .greet(ArgumentMatchers.any());
        Mockito.verify(helloWorld,
                       never())
               .greet("osman1");

        Mockito.verify(helloWorld,
                       Mockito.never())
               .hello();
        Mockito.verify(helloWorld,
                       Mockito.never())
               .sayHello(ArgumentMatchers.any(),
                         ArgumentMatchers.any());

    }


    @Test
    void testGreetings() {
        when(helloWorld.greet("osman"))
                .thenReturn("Greet osman");
        assertThat(greetings.greetings("osman"))
                .isEqualTo("Greet osman from Turkey");
        when(helloWorld.greet(ArgumentMatchers.anyString()))
                .thenReturn("Greet xyz");
        assertThat(greetings.greetings("sdhjkfkb sd"))
                .isEqualTo("Greet xyz from Turkey");
    }

    @Test
    void greetings9() {
//        when(helloWorld.sayGoodbye(ArgumentMatchers.any(),
//                                   ArgumentMatchers.any()))
//                .thenAnswer(i -> i.callRealMethod());
        assertThat(helloWorldSpy.sayGoodbye("osman",
                                            "yay"))
                .isEqualTo("hello osman yay");
    }

    @Test
    void greetings10() {
        Mockito.doReturn("osman yay")
               .when(helloWorldSpy)
               .sayGoodbye(ArgumentMatchers.any(),
                           ArgumentMatchers.any());

//        when(helloWorldSpy.sayGoodbye(ArgumentMatchers.any(),
//                                      ArgumentMatchers.any()))
//                .thenReturn("osman yay");
        assertThat(helloWorldSpy.sayGoodbye("osman",
                                            "yay"))
                .isEqualTo("osman yay");
        assertThat(helloWorldSpy.hello())
                .isEqualTo("hello world");

    }


    @Test
    void testGreetings1() {
        assertThat(greetings.greetings("osman",
                                       "yay"))
                .isEqualTo("Test hello osman yay from Turkey");
    }
}