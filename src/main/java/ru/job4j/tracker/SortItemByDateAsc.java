package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemByDateAsc implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        return item1.getCreated().compareTo(item2.getCreated());
    }
}
