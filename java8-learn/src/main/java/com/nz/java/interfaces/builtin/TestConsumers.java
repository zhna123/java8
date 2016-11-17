package com.nz.java.interfaces.builtin;

import com.nz.java.constructors.Person;

import java.util.function.Consumer;

/**
 * Created by zhna123 on 11/17/16.
 */
public class TestConsumers {
    public static void main(String[] args) {
        // operations performed on a single input argument
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
