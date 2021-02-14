package ru.job4j.pojo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.Date;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        first.setOwner("Ivan");
        first.setModel("B");
        first.setCreated(new Date(1212121212121L));
        License second = new License();
        second.setCode("audio");
        second.setOwner("Ivan");
        second.setModel("B");
        second.setCreated(new Date(1212121212121L));
        assertThat(first, is(second));
    }
}