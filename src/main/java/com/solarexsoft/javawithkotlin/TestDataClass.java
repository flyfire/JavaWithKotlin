package com.solarexsoft.javawithkotlin;

/**
 * Created by houruhou on 2018/10/23.
 * Desc:
 */
public class TestDataClass {
    String name;
    boolean isAged;

    public TestDataClass(String name, boolean isAged) {
        this.name = name;
        this.isAged = isAged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAged() {
        return isAged;
    }

    public void setAged(boolean aged) {
        isAged = aged;
    }
}
