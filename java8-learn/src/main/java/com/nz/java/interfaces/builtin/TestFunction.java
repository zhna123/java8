package com.nz.java.interfaces.builtin;

import java.util.function.Function;

/**
 * Created by zhna123 on 11/17/16.
 */
public class TestFunction {

    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer :: valueOf;
        Function<String, String> backToString = toInteger.andThen(String :: valueOf);

        // chain multiple functions together

        System.out.println(backToString.apply("123"));
    }
}
