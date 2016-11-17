package com.nz.java.scope;

import com.nz.java.interfaces.Converter;

/**
 * Created by zhna123 on 11/17/16.
 */
public class TestScope {

    public static void main(String[] args) {
        // this local variable doesn't need to be declared final
        // BUT it MUST be implicitly final for the code to compile (cant be changed)
        final int  num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        System.out.println(stringConverter.convert(2)); // 3
    }
}
