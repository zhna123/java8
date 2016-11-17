package com.nz.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhna123 on 11/17/16.
 */
public class Sort {

    /**
     *  old way to do sorting
     */
    List<String> sort(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        return names;
    }

    /**
     *  Lambda expression - version 1
     */
    List<String> sort1(List<String> names) {
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        return names;
    }

    /**
     *  Lambda expression - version 2
     *  One line method bodies you can skip both the braces {} and the return keyword.
     */
    List<String> sort2(List<String> names) {
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        return names;
    }

    /**
     *  Lambda expression - version 3
     *  java compiler is aware of the parameter types so you can skip them as well
     */
    List<String> sort3(List<String> names) {
        Collections.sort(names, (a, b) -> b.compareTo(a));
        return names;
    }
}
