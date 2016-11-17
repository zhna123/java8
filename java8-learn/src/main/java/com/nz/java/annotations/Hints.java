package com.nz.java.annotations;

import java.lang.annotation.Repeatable;

/**
 * Annotations in java8 are repeatable
 */
public @interface Hints {
    Hint[] value();
}


