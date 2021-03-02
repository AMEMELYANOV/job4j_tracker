package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class ComparatorTest {
    @Test
    public void sortByNameAscTest() {
        List<Item> items = Arrays.asList(
                new Item(1, "BBB"),
                new Item(2, "CC"),
                new Item(3, "A")
        );
        List<Item> expected = Arrays.asList(
                new Item(3, "A"),
                new Item(1, "BBB"),
                new Item(2, "CC")
        );
        Collections.sort(items, new SortItemByNameAsc());
        assertEquals(items, expected);
    }

    @Test
    public void sortByNameDescTest() {
        List<Item> items = Arrays.asList(
                new Item(1, "BBB"),
                new Item(2, "CC"),
                new Item(3, "A")
        );
        List<Item> expected = Arrays.asList(
                new Item(2, "CC"),
                new Item(1, "BBB"),
                new Item(3, "A")
        );
        Collections.sort(items, new SortItemByNameDesc());
        assertEquals(items, expected);
    }

    @Test
    public void sortByIdAscTest() {
        List<Item> items = Arrays.asList(
                new Item(3, "BBB"),
                new Item(2, "CC"),
                new Item(1, "A")
        );
        List<Item> expected = Arrays.asList(
                new Item(1, "A"),
                new Item(2, "CC"),
                new Item(3, "BBB")
        );
        Collections.sort(items, new SortItemByIdAsc());
        assertEquals(items, expected);
    }

    @Test
    public void sortByIdDescTest() {
        List<Item> items = Arrays.asList(
                new Item(1, "BBB"),
                new Item(2, "CC"),
                new Item(3, "A")
        );
        List<Item> expected = Arrays.asList(
                new Item(3, "A"),
                new Item(2, "CC"),
                new Item(1, "BBB")
        );
        Collections.sort(items, new SortItemByIdDesc());
        assertEquals(items, expected);
    }
}
