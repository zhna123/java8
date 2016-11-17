package com.nz.java.constructors;

/**
 * Created by zhna123 on 11/17/16.
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
