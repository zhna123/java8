package com.nz.java.interfaces;

/**
 * Created by zhna123 on 11/17/16.
 */
public class TestConverter {

    public static void main(String[] args) {
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);

        // java8 enable you to pass references of methods or constructors via the :: keyword

        // this is an example to reference a static method, we can also reference object methods
        Converter<String, Integer> converter = Integer::valueOf;

        Integer converted = converter.convert("123"); // 123
        System.out.println(converted); // 123

        // reference object method
        ObjectRefer or = new ObjectRefer();
        Converter<String, String>  converter1 = or::startWith;
        String converted1 = converter1.convert("Java");
        System.out.println(converted1);  // "J"

    }

}
