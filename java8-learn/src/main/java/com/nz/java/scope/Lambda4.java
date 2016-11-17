package com.nz.java.scope;

import com.nz.java.interfaces.Converter;

/**
 * Created by zhna123 on 11/17/16.
 */
public class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(outerNum + from);
        };

        Converter<Integer, String > stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(outerStaticNum + from);
        };

        System.out.println(stringConverter1.convert(10)); // 33
        System.out.println(stringConverter2.convert(20)); // 92
    }

    public static void main(String[] args) {
        new Lambda4().testScopes();
    }
}
