package com.training.test.usage;

import com.training.MyClass;
import org.junit.jupiter.api.*;

@TestMethodOrder(MyMethodOrderer.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class TestCase4 {

    private MyClass myClass = null;

    public TestCase4() {
    }

    @BeforeEach
    public void setUpTest() {
        myClass = new MyClass();
    }

    @AfterEach
    public void tearDownTest() {
    }

    @Test
    //@Order(3)
    @DisplayName("test1 display name")
    public void test1(TestInfo testInfo) {
        System.out.println(
                "//// " + testInfo.getDisplayName() + " (" + testInfo.getTestClass().get().getName() + "/" + testInfo.getTestMethod().get().getName()
                        + " ) başladı");
    }

    @Test
    //@Order(1)
    public void test2(TestReporter testReporter) {
        testReporter.publishEntry("Deneme raporu","test başarılı oldu 1");
        System.out.println("//// test 2 başladı");
    }

    @Test
    //@Order(2)
    public void test3() {
        System.out.println("//// test 3 başladı");
    }

    @Nested
    @Order(1)
    class MySubTest1 {
        @Test
        public void subTest1() {
            System.out.println("//// sub test 1 başladı");
        }

        @Test
        public void subTest2() {
            System.out.println("//// sub test 2 başladı");
        }

    }

    @Nested
    @Order(2)
    class MySubTest2 {
        @Test
        public void subTest2_1() {
            System.out.println("//// sub test 2_1 başladı");
        }

        @Test
        public void subTest2_2() {
            System.out.println("//// sub test 2_2 başladı");
        }

        @Nested
        class MySubTest2a {
            @Test
            public void subTest2a_1() {
                myClass.getCharCount("test");
                System.out.println("//// sub test 2a_1 başladı");
            }

            @Test
            public void subTest2a_2() {
                System.out.println("//// sub test 2a_2 başladı");
            }

        }

    }

}
