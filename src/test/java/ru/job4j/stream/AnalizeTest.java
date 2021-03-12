package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnalizeTest {
    @Test
    public void testInfo() {
        List<Analize.User>  previous = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "Alex"),
                new Analize.User(2, "Petr"),
                new Analize.User(3, "Pavel"),
                new Analize.User(4, "Ivan")
        ));
        List<Analize.User>  current = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "Igor"),
                new Analize.User(3, "Pavel"),
                new Analize.User(4, "Ivan"),
                new Analize.User(5, "Vasya")
        ));
        Analize.Info result = new Analize().diff(previous, current);
        Analize.Info expected = new Analize.Info();
        expected.setAdded(1);
        expected.setDeleted(1);
        expected.setChanged(1);
        assertEquals(expected, result);
    }
}
