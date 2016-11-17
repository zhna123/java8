package com.nz.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * two new targets
 */
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
public @interface MyAnnotation {
}
