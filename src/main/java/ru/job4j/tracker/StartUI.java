package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("\n" + "=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItem(Tracker tracker) {
        System.out.println("\n" + "=== Show Items ====");
        Item[] currentItems = tracker.findAll();
        for (Item currentItem : currentItems) {
            System.out.println(currentItem);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("\n" + "=== Edit Item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item editItem = new Item(name);
        if (tracker.replace(id, editItem)) {
            System.out.println("Edit completed");
        } else {
            System.out.println("Edit failed, id does not exist");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("\n" + "=== Delete Item ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Delete failed, id does not exist");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("\n" + "=== Show Item by id ====");
        int id = input.askInt("Enter id: ");
        Item findItem = tracker.findById(id);
        if (findItem != null) {
            System.out.println(findItem);
        }  else {
            System.out.println("Item with this id not found");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("\n" + "=== Find Item by name ====");
        String name = input.askStr("Enter name: ");
        Item[] arrItems = tracker.findByName(name);
        if (arrItems.length != 0) {
            for (Item arrItem : arrItems) {
                System.out.println(arrItem);
            }
        } else {
            System.out.println("No items with this name were found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItem(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
             StartUI.findItemsByName(input, tracker);
            } else if (select == 6) {
                System.out.println("\n" + "=== Exit Program ====");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("\n" + "Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}