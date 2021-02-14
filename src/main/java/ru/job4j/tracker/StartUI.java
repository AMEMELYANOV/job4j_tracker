package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
//        Item item = new Item();
//        System.out.println(item.getCreated().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));

        Tracker tracker = new Tracker();
        Item item1 = new Item(1, "item1");
        tracker.add(item1);
        System.out.println(tracker.findById(1) + " " + tracker.findById(1).getId()
                + " " + tracker.findById(1).getName());
    }
}
