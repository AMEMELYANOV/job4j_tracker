package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("\n" + "=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("\n" + "=== Show Items ====");
                Item[] currentItems = tracker.findAll();
                for (int i = 0; i < currentItems.length; i++) {
                    System.out.println(currentItems[i]);
                }
            } else if (select == 2) {
                System.out.println("\n" + "=== Edit Item ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                Item editItem = new Item(name);
                if (tracker.replace(id, editItem)) {
                    System.out.println("Edit completed");
                } else {
                    System.out.println("Edit failed, id does not exist");
                }

            } else if (select == 3) {
                System.out.println("\n" + "=== Delete Item ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Delete failed, id does not exist");
                }
            } else if (select == 4) {
                System.out.println("\n" + "=== Show Item by id ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item findItem = tracker.findById(id);
                if (findItem != null) {
                    System.out.println(findItem);
                }  else {
                    System.out.println("Item with this id not found");
                }
            } else if (select == 5) {
                System.out.println("\n" + "=== Find Item by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] arrItems = tracker.findByName(name);
                if (arrItems.length != 0) {
                    for (int i = 0; i < arrItems.length; i++) {
                        System.out.println(arrItems[i]);
                    }
                } else {
                    System.out.println("No items with this name were found");
                }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}