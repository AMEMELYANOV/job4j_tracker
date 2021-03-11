package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        return stringToHasMap(left).equals(stringToHasMap(right));
    }

    public static HashMap<String, Integer> stringToHasMap(String str) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String s : str.split("")) {
            if (!result.containsKey(s)) {
                result.put(s, 1);
            } else {
                result.computeIfPresent(s, (key, value) -> value + 1);
            }
        }
        return result;
    }
}