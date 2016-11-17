package com.nz.java.interfaces.builtin;

import java.util.Optional;

/**
 * Created by zhna123 on 11/17/16.
 */
public class TestOptionals {

    public static void main(String[] args) {
        // to prevent nullPointerException
        Optional<String> optional = Optional.of("bam");

        System.out.println(optional.isPresent()); // true
        System.out.println(optional.get());  // "bam"
        System.out.println(optional.orElse("fallback"));  // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));  // 'b'
    }
}
