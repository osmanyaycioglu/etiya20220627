package com.training.test.usage;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCase2 {

    public TestCase2() {
        System.out.println("%%%%%%% TestCase1 created");
    }

    @BeforeAll
    public void setUpClass() {
        System.out.println("------------ MyClassTest setup ----------------");
    }

    @AfterAll
    public void tearDownClass() {
        System.out.println("------------ MyClassTest tear down ----------------");
    }

    @BeforeEach
    public void setUpTest() {
        System.out.println("**** MyClassTest setting test");
    }

    @AfterEach
    public void tearDownTest() {
        System.out.println("**** MyClassTest tear down test");
    }

    @Test
    public void test1() {
        System.out.println("//// test 1 başladı");
    }

    @Test
    public void test2() {
        System.out.println("//// test 2 başladı");
    }

}
