package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SearchAttTest {

    @Test
    public void whenFilterByNameEqual() {
        List<Attachment> lst = new ArrayList<>();
        List<Attachment> expect = new ArrayList<>();
            lst.add(new Attachment("bug", 99));
            lst.add(new Attachment("ant", 100));
            lst.add(new Attachment("bee", 101));
            expect.add(new Attachment("bug", 99));
        lst = SearchAtt.filterName(lst, "bug");
        assertThat(lst, is(expect));
    }

    @Test
    public void whenFilterByNameEmpty() {
        List<Attachment> lst = new ArrayList<>();
        List<Attachment> expect = new ArrayList<>();
        lst.add(new Attachment("bug", 99));
        lst.add(new Attachment("ant", 100));
        lst.add(new Attachment("bee", 101));
        lst = SearchAtt.filterName(lst, "bugs");
        assertThat(lst, is(expect));
    }

    @Test
    public void whenFilterBySizeEqual() {
        List<Attachment> lst = new ArrayList<>();
        List<Attachment> expect = new ArrayList<>();
        lst.add(new Attachment("bug", 99));
        lst.add(new Attachment("ant", 100));
        lst.add(new Attachment("bee", 101));
        expect.add(new Attachment("bee", 101));
        lst = SearchAtt.filterSize(lst, 100);
        assertThat(lst, is(expect));
    }

    @Test
    public void whenFilterBySizeEmpty() {
        List<Attachment> lst = new ArrayList<>();
        List<Attachment> expect = new ArrayList<>();
        lst.add(new Attachment("bug", 99));
        lst.add(new Attachment("ant", 100));
        lst.add(new Attachment("bee", 101));
        lst = SearchAtt.filterSize(lst, 101);
        assertThat(lst, is(expect));
    }
}
