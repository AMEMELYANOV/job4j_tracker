package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new Exit()
        ));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = Tracker.getInstance();
        Item item = new Item("Item");
        tracker.add(item);
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new ShowAction(out),
                new Exit()
        ));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + System.lineSeparator() + "=== Show Items ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item", "0", "Item1", "1"}
        );
        Tracker tracker = Tracker.getInstance();
        Item item = new Item("Item");
        tracker.add(item);
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByNameAction(out),
                new Exit()
        ));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + System.lineSeparator() + "=== Find Item by name ===="
                        + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + System.lineSeparator() + "=== Find Item by name ===="
                        + System.lineSeparator()
                        + "No items with this name were found" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "0", "2", "1"}
        );
        Tracker tracker = Tracker.getInstance();
        Item item = new Item("Item");
        tracker.add(item);
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByIdAction(out),
                new Exit()
        ));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + System.lineSeparator() + "=== Find Item by id ===="
                        + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + System.lineSeparator() + "=== Find Item by id ===="
                        + System.lineSeparator()
                        + "Item with this id not found" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new Exit()
        ));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}
