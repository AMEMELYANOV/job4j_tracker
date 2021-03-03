package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println(System.lineSeparator() + "=== Show Items ====");
        List<Item> currentItems = tracker.findAll();
        for (Item currentItem : currentItems) {
            out.println(currentItem);
        }
        return true;
    }
}
