package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        Set<String> set = new HashSet<>(Arrays.asList(origin.replaceAll("\\p{P}", "").split(" ")));
        for (String s : line.replaceAll("\\p{P}", "").split(" ")) {
            if (!set.contains(s)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}