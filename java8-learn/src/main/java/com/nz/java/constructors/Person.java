package com.nz.java.constructors;

/**
 * Example bean with different constructors
 */
public class Person {
    public String firstName;
    public String lastName;

    public Person() {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
