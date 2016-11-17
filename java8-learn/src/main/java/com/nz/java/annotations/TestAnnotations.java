package com.nz.java.annotations;

/**
 * TODO this threw null pointer exception. need to look up this test
 */
public class TestAnnotations {
    public static void main(String[] args) {
        Hint hint = Person2.class.getAnnotation(Hint.class);
        System.out.println(hint);  //null

        Hints hints1 = Person2.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);  // 2

        Hint[] hints2 = Person2.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);  // 2
    }
}
