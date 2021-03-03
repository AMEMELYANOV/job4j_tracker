package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает объект - "банковский счет"
 * объект содержит два поля: текстовое поле значения номера реквезита банковского счета (requisite)
 *  и числовое поле состояния денежного баланса банковского счета (balance)
 * @author ALEXANDER EMELYANOV
 * @version 1.0
 */
public class Account {
    /**
     * Текстовое поле значения номера реквизита банковского счета
     */
    private String requisite;
    /**
     * Числовое поле состояния денежного баланса банковского счета
     */
    private double balance;

    /**
     * Конструктор класса, принимает на вход значение номера реквизита
     * и баланс денежного счета, инициализирует этими параметрами поля, создаваемого объекта
     * @param requisite номер реквизита банковского счета
     * @param balance денежный баланс банковского счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает номер реквизита банковского счета
     * @return номер реквизита банковского счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает на вход номер реквизита для банковского счета и присваивает его
     * соответсвующему полю счета
     * @param requisite номер реквизита банковского счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает денежный баланс банковского счета
     * @return денежный баланс банковского счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает на вход денежный баланс банковского счета и присваивает его
     * соответсвующему полю счета
     * @param balance денежный баланс банковского счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод проверки эквивалентности объектов класса Account
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод генерации hashcode объекта класса Account
     * @return hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}