package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {
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
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    @Test
    public void whenAdd() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("name");
            int id = tracker.add(item).getId();
            assertEquals("name", tracker.findById(id).getName());
        }
    }

    @Test
    public void whenDelete() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("name");
            int id = tracker.add(item).getId();
            assertTrue(tracker.delete(item.getId()));
            assertNull(tracker.findById(id));
        }
    }

    @Test
    public void whenFindAll() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            List<Item> rsl = new ArrayList<>();
            rsl.add(tracker.add(new Item("name1")));
            rsl.add(tracker.add(new Item("name2")));
            assertEquals(rsl, tracker.findAll());

        }
    }

    @Test
    public void whenFindById() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item;
            item = tracker.add(new Item("name"));
            Item expected = tracker.findById(item.getId());
            assertEquals(item, expected);
        }
    }

    @Test
    public void whenReplace() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item;
            item = tracker.add(new Item("name"));
            item.setName("newName");
            assertTrue(tracker.replace(item.getId(), item));
            assertEquals(item, tracker.findById(item.getId()));
        }
    }

    @Test
    public void whenFindByName() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            List<Item> rsl = new ArrayList<>();
            rsl.add(tracker.add(new Item("name")));
            rsl.add(tracker.add(new Item("name")));
            assertEquals(rsl, tracker.findByName("name"));
        }
    }
}