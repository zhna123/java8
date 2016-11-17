package com.nz.java.interfaces.builtin;

import com.nz.java.constructors.Person;

import java.util.Comparator;

/**
 * Created by zhna123 on 11/17/16.
 */
public class TestComparators {
    public static void main(String[] args) {
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        System.out.println(comparator.compare(p1, p2));  // >0
        System.out.println(comparator.reversed().compare(p1, p2));  // <0
    }
}
