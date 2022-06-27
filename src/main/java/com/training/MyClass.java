package com.training;

public class MyClass {

    public Integer getCharCount(String str) {
        if (str == null) {
            return 0;
        }
        return str.trim().length();
    }

}
