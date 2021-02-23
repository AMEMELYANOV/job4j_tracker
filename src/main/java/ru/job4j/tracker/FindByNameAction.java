package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction{
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println(System.lineSeparator() + "=== Find Item by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> arrItems = tracker.findByName(name);
        if (arrItems.size() != 0) {
            for (Item arrItem : arrItems) {
                out.println(arrItem);
            }
        } else {
            out.println("No items with this name were found");
        }
        return true;
    }
}
