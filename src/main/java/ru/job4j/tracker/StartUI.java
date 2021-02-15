package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        item.setId(1);
        item.setName("Item1");
        System.out.println(item.toString());
    }
}
