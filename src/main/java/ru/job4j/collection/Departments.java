package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += el;
                tmp.add(start);
                start += "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("K2", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Arrays.asList("K2", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2");
        sortAsc(result);
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println("------------------------");
        sortDesc(result);
        for (String s : result) {
            System.out.println(s);
        }
    }
}