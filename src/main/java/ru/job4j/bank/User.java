package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает объект - "пользователь"
 * объект содержит два текстовых поля: номер паспорта
 * (passport) пользователя и его имя (username)
 * @author ALEXANDER EMELYANOV
 * @version 1.0
 */
public class User {
     /**
     * Текстовое поле номера паспорта
     */
    private String passport;

    /**
     * Текстовое поле имени пользователя
     */
    private String username;

    /**
     * Конструктор класса, принимает на вход номер паспорта и имя пользователя,
     * инициализирует этими параметрами поля, создаваемого объекта
     * @param passport - номер паспорта
     * @param username - имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает номер пасспорта
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает на вход номер паспорта и присваивает его соответствующему полю пользователя
     * @param passport номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает имя пользователя
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает на вход имя пользователя и присваивает его соответствующему полю пользователя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод проверки эквивалентности объектов класса User
     * @param o сравниваемый объект
     * @return возвращает булево значение эквивалентности
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод генерации hashcode объекта класса User
     * @return hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}