package com.nz.java.interfaces;

/**
 * Each lambda corresponds to a given type, specified by an interface
 * functional interface must contain exactly ONE abstract method declaration
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
