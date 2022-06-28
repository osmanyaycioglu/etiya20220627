package com.training.test.usage;

import com.training.MyClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestCase1 {


    public TestCase1() {
        System.out.println("%%%%%%% TestCase1 created");
    }

    @BeforeAll
    public static void setUpClass() {
        System.out.println("------------ MyClassTest setup ----------------");
    }

    @AfterAll
    public static void tearDownClass() {
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
