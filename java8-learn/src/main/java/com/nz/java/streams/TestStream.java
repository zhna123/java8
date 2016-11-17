package com.nz.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by zhna123 on 11/17/16.
 */
public class TestStream {

    public static void main(String[] args) {

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");


        // filter
        // accept a predicate to filter element of the stream
        // intermediate operation, means we can call another stream operation (forEach) on the result
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                // forEach accepts a consumer to be executed for each element
                // terminal operation, we cannot call another stream operation
                .forEach(System.out::println);  // aaa2   aaa1

        // sorted
        // intermediate operation which returns a sorted view of the stream
        // can pass a custom comparator
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);  // aaa1 aaa2
        // sorted only create a sorted view of the stream. The backed collection ordering is untouched.

        // map
        // intermediate operation converts each element into another object via the given function
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> a.compareTo(b))
                .forEach(System.out::println);

        // match
        // terminal and return a boolean result
        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);  // true

        boolean allStartsWithA =
                stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);   // false

        boolean nonStartsWithZ =
                stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));  // true
        System.out.println(nonStartsWithZ);

        // count
        // terminal operation returning the number of elements in the stream as a long
        long startsWithB =
                stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();
        System.out.println(startsWithB);   // 3

        // reduce
        // terminal operation performs a reduction on the elements of the stream with the given
        // function. The result is an Optional holding the reduced value
        Optional<String> reduced =
                stringCollection
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out :: println); // aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2

    }
}
