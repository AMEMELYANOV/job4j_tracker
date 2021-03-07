package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String head1 = o1.split("/")[0];
        String head2 = o2.split("/")[0];
        return head1.equals(head2) ? o1.compareTo(o2) : o2.compareTo(o1);
    }
}