package com.training;

import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyClassTest {

    public MyClassTest() {
        System.out.println("MyClassTest yaratıldı");
    }

    private MyClass myClass = null;

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
        myClass = new MyClass();
    }

    @AfterEach
    public void tearDownTest() {
        System.out.println("**** MyClassTest tear down test");
        myClass = new MyClass();
    }

    @Test
    @DisplayName("Character count -> all tests")
    public void getCharCountTest() {
        System.out.println("getCharCountTest test başladı");
        Integer charCount = myClass.getCharCount("osman");
        if (charCount != 5) {
            throw new AssertionFailedError("Test failed for osman");
        }

//        try {
//            charCount = myClass.getCharCount(null);
//        } catch (NullPointerException e) {
//            System.out.println("Beklenen");
//        }  catch (Exception e) {
//            throw new AssertionFailedError("Test failed for null");
//        }

        charCount = myClass.getCharCount(null);
        if (charCount != 0) {
            throw new AssertionFailedError("Test failed for null");
        }

        charCount = myClass.getCharCount("    ");
        if (charCount != 0) {
            throw new AssertionFailedError("Test failed for blank");
        }

        charCount = myClass.getCharCount("  osman  ");
        if (charCount != 5) {
            throw new AssertionFailedError("Test failed for blank");
        }

        charCount = myClass.getCharCount("  os man  ");
        if (charCount != 6) {
            throw new AssertionFailedError("Test failed for 'os man'");
        }

        // throw new IllegalArgumentException("Test failed");

    }

    @Test
    public void getCharCount_blank_Test_with_assertions() {
        System.out.println("getCharCount_blank_Test_with_assertions test başladı");
        assertEquals(0,
                     myClass.getCharCount("    "),
                     "Test failed for full blank");
        assertEquals(5,
                     myClass.getCharCount("  osman  "),
                     "Test failed for ' osman ' blank");
        assertEquals(6,
                     myClass.getCharCount("  os man  "),
                     "Test failed for 'os man'");
    }

    @Test
    public void getCharCount_blank_Test_with_assertion_all() {
        System.out.println("getCharCount_blank_Test_with_assertion_all test başladı");
        assertAll("Ana boşluk testi : ",
                  () -> assertEquals(0,
                                     myClass.getCharCount("    "),
                                     "Test failed for full blank"),
                  () -> {
                      System.out.println("Test 2 çalıştı");
                      assertEquals(5,
                                   myClass.getCharCount("  osman  "),
                                   "Test failed for ' osman ' blank");
                  },
                  () -> {
                      System.out.println("Test 3 çalıştı");
                      assertEquals(6,
                                   myClass.getCharCount("  os man  "),
                                   "Test failed for 'os man'");
                  }
        );
    }

    @Test
    public void getCharCount_blank_Test() {
        System.out.println("getCharCount_blank_Test test başladı");
        Integer charCount = myClass.getCharCount("    ");
        if (charCount != 0) {
            throw new AssertionFailedError("Test failed for blank",
                                           0,
                                           charCount);
        }

        charCount = myClass.getCharCount("  osman  ");
        if (charCount != 5) {
            throw new AssertionFailedError("Test failed for blank");
        }

        charCount = myClass.getCharCount("  os man  ");
        if (charCount != 6) {
            throw new AssertionFailedError("Test failed for 'os man'");
        }
    }


}
