package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Show Item by id ====");
        int id = input.askInt("Enter id: ");
        Item findItem = tracker.findById(id);
        if (findItem != null) {
            System.out.println(findItem);
        }  else {
            System.out.println("Item with this id not found");
        }
        return true;
    }
}
