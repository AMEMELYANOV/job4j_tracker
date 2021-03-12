package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        HashMap<String, Integer> leftMap = new HashMap<>();
        for (String s : left.split("")) {
            leftMap.computeIfPresent(s, (key, value) -> value + 1);
            leftMap.putIfAbsent(s, 1);

        }
        for (String s : right.split("")) {
            if (!leftMap.containsKey(s)) {
                return false;
            } else if (leftMap.get(s) == 1) {
                leftMap.remove(s);
            } else {
                leftMap.computeIfPresent(s, (key, value) -> value - 1);
            }
        }
        return leftMap.isEmpty();
    }
}