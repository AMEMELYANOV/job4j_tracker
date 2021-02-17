package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Find Item by name ====");
        String name = input.askStr("Enter name: ");
        Item[] arrItems = tracker.findByName(name);
        if (arrItems.length != 0) {
            for (Item arrItem : arrItems) {
                System.out.println(arrItem);
            }
        } else {
            System.out.println("No items with this name were found");
        }
        return true;
    }
}
