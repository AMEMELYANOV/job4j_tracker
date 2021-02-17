package ru.job4j.tracker;

public class ShowAction implements UserAction{
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Show Items ====");
        Item[] currentItems = tracker.findAll();
        for (Item currentItem : currentItems) {
            System.out.println(currentItem);
        }
        return true;
    }
}
