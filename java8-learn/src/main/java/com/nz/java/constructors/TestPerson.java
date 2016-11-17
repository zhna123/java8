package com.nz.java.constructors;

/**
 * Created by zhna123 on 11/17/16.
 */
public class TestPerson {

    public static void main(String[] args) {
        // use :: with constructors

        // create a reference to Person constructor
        PersonFactory<Person> personFactory = Person::new;
        // compiler auto choose the correct constructor by matching the signature of PersonFactory.create
        Person person = personFactory.create("Peter", "Parker");
    }
}
