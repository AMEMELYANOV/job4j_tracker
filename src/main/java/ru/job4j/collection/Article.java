package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        Set<String> set = new HashSet<>(Arrays.asList(delPunctuation(origin).split(" ")));
        for (String s : delPunctuation(line).split(" ")) {
            if (!set.contains(s)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static String delPunctuation(String str) {
        StringBuilder rsl = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isSpaceChar(c)) {
                rsl.append(c);
            }
        }
        return rsl.toString().toLowerCase(Locale.ROOT);
    }
}