package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> phoneContains = person -> person
                .getPhone()
                .contains(key);
        Predicate<Person> surnameContains = person -> person
                .getSurname()
                .contains(key);
        Predicate<Person> adressContains = person -> person
                .getAddress()
                .contains(key);
        Predicate<Person> nameContains = person -> person
                .getName()
                .contains(key);
        var combine = phoneContains
                .or(surnameContains)
                .or(adressContains)
                .or(nameContains);

        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}