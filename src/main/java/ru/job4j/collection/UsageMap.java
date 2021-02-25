package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov@yandex.ru", "Ivanov Ivan Ivanovich");
        map.put("petrov@yandex.ru", "Petrov Petr Petrovich");
        map.put("sidorov@yandex.ru", "Sidorov Sidor Sidorovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}