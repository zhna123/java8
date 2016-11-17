package com.nz.java.interfaces.builtin;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by zhna123 on 11/17/16.
 */
public class TestPredicate {

    public static void main(String[] args) {

        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));  // true
        System.out.println(predicate.negate().test("foo"));  // false

        Predicate<Boolean> nonNull = Objects :: nonNull;
        Predicate<Boolean> isNull = Objects :: isNull;

        Predicate<String> isEmpty = String :: isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

    }
}
