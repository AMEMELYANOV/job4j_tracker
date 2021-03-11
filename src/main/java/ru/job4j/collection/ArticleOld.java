package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticleOld {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        List<String> originArr = new ArrayList<>(Arrays.asList(delPuct(origin).split(" ")));
        List<String> lineArr = new ArrayList<>(Arrays.asList(delPuct(line).split(" ")));
        for (String s : lineArr) {
            if (!originArr.contains(s)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
    
    public static String delPuct(String str) {
        StringBuilder rsl = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isSpaceChar(c)) {
                rsl.append(c);
            }
        }
        return rsl.toString();
    }
    
}
