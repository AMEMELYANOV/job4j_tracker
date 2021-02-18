package ru.job4j.tracker;

public class ShowAction implements UserAction{
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
        Item[] currentItems = tracker.findAll();
        for (Item currentItem : currentItems) {
            out.println(currentItem);
        }
        return true;
    }
}
