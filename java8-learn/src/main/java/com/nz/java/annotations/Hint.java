package com.nz.java.annotations;

import java.lang.annotation.Repeatable;

/**
 * java8 enables us to use multiple annotations of the same type by declaring the annotation @repeatable
 */
@Repeatable(Hints.class)
public @interface Hint {
    String value();
}
