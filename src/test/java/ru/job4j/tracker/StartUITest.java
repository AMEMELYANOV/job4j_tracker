package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    public Connection init() {
        try (InputStream in = SqlTracker.class
                .getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
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
    public void findAllAction() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
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
                        + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findByNameAction() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item", "0", "Item1", "1"}
        );
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
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
    public void findByIdAction() throws SQLException {
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("Item");
        int id = tracker.add(item).getId();
        item.setId(id);
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), "1"}
        );
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
        ));
    }

    @Test
    public void whenInvalidExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
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
