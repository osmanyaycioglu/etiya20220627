package com.training;

import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

public class MyClassTest {

    public MyClassTest() {
        System.out.println("MyClassTest yaratıldı");
    }

    private MyClass myClass = null;

    @BeforeEach
    public void initXyz(){
        System.out.println("MyClassTest initXyz çağrıldı");
        myClass = new MyClass();
    }

    @AfterEach
    public void destroyXyz(){
        System.out.println("MyClassTest destroyXyz çağrıldı");
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
        Assertions.assertEquals(0,myClass.getCharCount("    "),"Test failed for full blank");
        Assertions.assertEquals(5,myClass.getCharCount("  osman  "),"Test failed for ' osman ' blank");
        Assertions.assertEquals(6,myClass.getCharCount("  os man  "),"Test failed for 'os man'");
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
