package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile() {
    }

    public Profile(Address address) {
        this.address = address;
    }

    List<Address> collect(List<Profile> profiles) {
        return profiles
                .stream()
                .map(profile -> profile.address)
                .collect(Collectors.toList());
    }
}

