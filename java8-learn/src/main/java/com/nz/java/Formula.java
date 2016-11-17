package com.nz.java;

/**
 * Created by zhna123 on 11/17/16.
 */
public interface Formula {

    double calculate(int a);

    /**
     * add non-abstract method implementations to interfaces by use "default" keyword
     * - Extension Methods
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    // call calculate method inside
    default double callCalculate(int a) {
        return calculate(a + 1);
    }
}
