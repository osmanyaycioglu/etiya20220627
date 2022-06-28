package com.training.test.usage;

import com.training.MyClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestCase6 {

    private MyClass myClass = null;


    public TestCase6() {

    }

    @BeforeEach
    public void setUpTest() {
        myClass = new MyClass();
    }

    @AfterEach
    public void tearDownTest() {

    }

    @ParameterizedTest
    @ValueSource(ints = {
            10, 20, 30, 40, 55, 31, 45, 41, 87
    })
    public void test1(int xyz) {
        System.out.println(xyz);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0,   ", "1,   g   ", "5,  osman  "
    })
    public void getCharCount_blank_Test_with_assertions(String testData) {
        String[] split = testData.split(",");
        assertEquals(Integer.parseInt(split[0]),
                     myClass.getCharCount(split[1]),
                     "Blank test failed for "
                             + split[1] + " blank");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0,   ", "1,   g   ", "5,  osman  ", "6,mehmet"
    }, ignoreLeadingAndTrailingWhitespace = false)
    public void getCharCount_blank_Test_with_assertions_with_csv_source(int result,
                                                                        String testData) {
        assertEquals(result,
                     myClass.getCharCount(testData),
                     "Blank test failed for "
                             + testData + " blank");
    }

    @ParameterizedTest
    @CsvFileSource(files = "blank_test.txt", ignoreLeadingAndTrailingWhitespace = false)
    public void getCharCount_blank_Test_with_assertions_with_csv_file_source(int result,
                                                                             String testData) {
        assertEquals(result,
                     myClass.getCharCount(testData),
                     "Blank test failed for "
                             + testData + " blank");
    }

    @ParameterizedTest
    @MethodSource("generateBlankData")
    public void getCharCount_blank_Test_with_assertions_with_method_source(TestData testData) {
        assertEquals(testData.result,
                     myClass.getCharCount(testData.testData),
                     "Blank test failed for "
                             + testData + " blank");
    }

    static Collection<TestData> generateBlankData() {
        List<TestData> testDataList = new ArrayList<>();
        testDataList.add(new TestData().result(1)
                                       .data("   y   "));
        testDataList.add(new TestData().result(5)
                                       .data("   osman   "));
        testDataList.add(new TestData().result(6)
                                       .data("   yalçın   "));
        testDataList.add(new TestData().result(4)
                                       .data("   ayşe   "));
        return testDataList;
    }


    private static class TestData {
        Integer result;
        String testData;

        public TestCase6.TestData result(Integer result) {
            this.result = result;
            return this;
        }

        public TestCase6.TestData data(String testData) {
            this.testData = testData;
            return this;
        }

        @Override
        public String toString() {
            return "TestData{" +
                    "result=" + result +
                    ", testData='" + testData + '\'' +
                    '}';
        }
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgProvider.class)
    public void getCharCount_blank_Test_with_assertions_with_argument_source(TestData testData,
                                                                             String str) {
        System.out.println("Test : " + str);
        assertEquals(testData.result,
                     myClass.getCharCount(testData.testData),
                     "Blank test failed for "
                             + testData + " blank");
    }

    static class MyArgProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new TestData().result(1)
                                                      .data("   y   "),
                                        "y testi"),
                    Arguments.arguments(new TestData().result(5)
                                                      .data("   osman   "),
                                        "osman testi"),
                    Arguments.arguments(new TestData().result(4)
                                                      .data("   ayşe   "),
                                        "Ayşe testi"),
                    Arguments.arguments(new TestData().result(3)
                                                      .data("   ali   "),
                                        "ali testi")
            );
        }
    }

}
