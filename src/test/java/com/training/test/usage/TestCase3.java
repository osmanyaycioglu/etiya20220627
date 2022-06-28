package com.training.test.usage;

import org.junit.jupiter.api.*;

@TestMethodOrder(MyMethodOrderer.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCase3 {

    public TestCase3() {
    }

    @BeforeEach
    public void setUpTest() {
    }

    @AfterEach
    public void tearDownTest() {
    }

    @Test
    //@Order(3)
    public void test1() {
        System.out.println("//// test 1 başladı");
    }

    @Test
    //@Order(1)
    public void test2() {
        System.out.println("//// test 2 başladı");
    }

    @Test
    //@Order(2)
    public void test3() {
        System.out.println("//// test 3 başladı");
    }

}
