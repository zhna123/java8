package com.nz.java.annotations;

/**
 * repeatable annotation
 */
// this way, the java compiler implicitly sets up the @Hints annotation under the hood.
@Hint("hint1")
@Hint("hint2")
public class Person2 {
}
