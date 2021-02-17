package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Edit Item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item editItem = new Item(name);
        if (tracker.replace(id, editItem)) {
            System.out.println("Edit completed");
        } else {
            System.out.println("Edit failed, id does not exist");
        }
        return true;
    }
}
