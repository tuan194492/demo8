package com.example.demo8.model;

import javax.inject.Named;

@Named(value = "model")
public class Model {
    private int testValue = 1;

    public int getTestValue() {
        return testValue;
    }

    public void setTestValue(int testValue) {
        this.testValue = testValue;
    }
}
