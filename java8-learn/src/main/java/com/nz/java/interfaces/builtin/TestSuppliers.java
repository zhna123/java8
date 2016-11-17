package com.nz.java.interfaces.builtin;

import com.nz.java.constructors.Person;

import java.util.function.Supplier;

/**
 * Created by zhna123 on 11/17/16.
 */
public class TestSuppliers {

    public static void main(String[] args) {

        // produce a result of a given generic type
        // no args accepted
        Supplier<Person> personSuppliers = Person :: new;
        personSuppliers.get();  // get a person instance
    }

}
