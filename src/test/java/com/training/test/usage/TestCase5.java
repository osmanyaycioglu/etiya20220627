package com.training.test.usage;

import com.training.MyClass;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase5 {

    private static Object[][] testData = new Object[][]{
            {0, "   "}, {5, "  osman  "}, {6, "  os man  "}
    };

    private static class TestData {
        Integer result;
        String testData;

        public TestData result(Integer result) {
            this.result = result;
            return this;
        }

        public TestData data(String testData) {
            this.testData = testData;
            return this;
        }
    }

    private static Map<Integer, TestData> testDatas = null;
    private static List<TestData> testDataList = null;

    public TestCase5() {
    }

    private MyClass myClass = null;


    @BeforeAll
    public static void init() {
        testDatas = new HashMap<>();
        testDatas.put(1,
                      new TestData().result(0)
                                    .data("   "));
        testDatas.put(2,
                      new TestData().result(0)
                                    .data("      "));
        testDatas.put(3,
                      new TestData().result(1)
                                    .data("  d   "));
        testDatas.put(4,
                      new TestData().result(5)
                                    .data("  osman   "));
        testDatas.put(5,
                      new TestData().result(6)
                                    .data("  os man   "));

        testDataList = new ArrayList<>();

        testDataList.add(new TestData().result(0)
                                       .data("   "));
        testDataList.add(new TestData().result(0)
                                       .data("      "));
        testDataList.add(new TestData().result(1)
                                       .data("  d   "));
        testDataList.add(new TestData().result(5)
                                       .data("  osman   "));
        testDataList.add(new TestData().result(6)
                                       .data("  os man   "));

    }

    @BeforeEach
    public void setUpTest() {
        myClass = new MyClass();
    }

    @RepeatedTest(10)
    public void countRepeatedTest() {
        assertEquals(1,
                     myClass.getCharCount(" a "),
                     "Test patladı");

    }

    @RepeatedTest(value = 5, name = "blank test with dynamic data {currentRepetition} ---> {totalRepetitions}")
    public void getCharCount_blank_Test_with_assertions_with_map_data(RepetitionInfo ri) {
        int currentRepetition = ri.getCurrentRepetition();
        TestData testData = testDatas.get(currentRepetition);
        assertEquals(testData.result,
                     myClass.getCharCount(testData.testData),
                     "Blank test (" + currentRepetition + "/" + ri.getTotalRepetitions() + ") failed for "
                             + testData.testData + " blank");
    }

    @RepeatedTest(value = 5, name = "blank test with dynamic data {currentRepetition} ---> {totalRepetitions}")
    public void getCharCount_blank_Test_with_assertions_with_list_data(RepetitionInfo ri) {
        int currentRepetition = ri.getCurrentRepetition();
        TestData testData = testDataList.get(currentRepetition - 1);
        assertEquals(testData.result,
                     myClass.getCharCount(testData.testData),
                     "Blank test (" + currentRepetition + "/" + ri.getTotalRepetitions() + ") failed for "
                             + testData.testData + " blank");
    }

    @RepeatedTest(3)
    public void getCharCount_blank_Test_with_assertions(RepetitionInfo ri) {
        int currentRepetition = ri.getCurrentRepetition();
        Object[] data = testData[currentRepetition - 1];
        String testDataString = (String) data[1];
        assertEquals(data[0],
                     myClass.getCharCount(testDataString),
                     "Blank test (" + currentRepetition + "/" + ri.getTotalRepetitions() + ") failed for "
                             + testDataString + " blank");
    }

}
