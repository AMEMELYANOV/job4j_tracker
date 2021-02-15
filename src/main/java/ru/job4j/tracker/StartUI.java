package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
//        Item item = new Item();
//        System.out.println(item.getCreated().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));

        Tracker tracker = new Tracker();
        Item item1 = new Item(1, "item1");
        tracker.add(item1);
//        System.out.println(tracker.findById(1) + " " + tracker.findById(1).getId()
//                + " " + tracker.findById(1).getName());
        Item item2 = new Item(1, "item2");
        Item item3 = new Item(1, "item3");
        Item item4 = new Item(1, "item4");
        Item item5 = new Item(1, "item5");
        Item item6 = new Item(1, "item6");
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.add(item6);
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(tracker.findAll()[i].getName());
        }
        System.out.println("------------------------------------");
        tracker.delete(2);
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(tracker.findAll()[i].getName());
        }

    }
}
