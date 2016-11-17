package com.nz.java.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps don't support streams.
 */
public class TestMap {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        for (int i=0; i<10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));

        // compute
        // num is key, val is current value
        map.computeIfPresent(3, (num, val) -> val + num);  // map to new value
        System.out.println(map.get(3));  //val33

        map.computeIfPresent(9, (num, val) -> null);  // null will remove the map entry
        System.out.println(map.containsKey(9));  // false

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.get(23));  // val23

        map.computeIfAbsent(3, num -> "bam");
        System.out.println(map.get(3));  // val33

        // remove entries
        map.remove(3, "val3");
        System.out.println(map.get(3));  // val33

        map.remove(3, "val33");
        System.out.println(map.get(3));  // null

        // getOrDefault
        System.out.println(map.getOrDefault(42, "not found")); // not found

        // merging entries
        // merge either put the key/value into the map if no entry for the key exists,
        // or the merging function will be called to change the existing value
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9)); // val9

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9)); // val9concat

        System.out.println(map.merge(15, "val15", (value, newValue) -> value.concat(newValue)));  // val15

        System.out.println(map.merge(15, "msg", String::concat)); // val15msg

    }
}
