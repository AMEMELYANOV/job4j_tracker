package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println(System.lineSeparator() + "=== Edit Item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item editItem = new Item(name);
        if (tracker.replace(id, editItem)) {
            out.println("Edit completed");
        } else {
            out.println("Edit failed, id does not exist");
        }
        return true;
    }
}
