package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenCollectIsNotEmpty() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(new Address("Moscow", "Lenina", 10, 49)));
        profiles.add(new Profile(new Address("Peterburg", "Kirova", 17, 85)));
        profiles.add(new Profile(new Address("Omsk", "Stroiteley", 3, 1)));

        Profile profile = new Profile();
        List<Address> rsl = profile.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenina", 10, 49));
        expected.add(new Address("Peterburg", "Kirova", 17, 85));
        expected.add(new Address("Omsk", "Stroiteley", 3, 1));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectIsEmpty() {
        List<Profile> profiles = new ArrayList<>();

        Profile profile = new Profile();
        List<Address> rsl = profile.collect(profiles);
        List<Address> expected = new ArrayList<>();
        assertThat(rsl, is(expected));
    }
}
