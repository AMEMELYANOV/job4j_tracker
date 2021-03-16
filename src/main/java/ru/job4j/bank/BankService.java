package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

/**
 * Класс описывает работу банковского сервиса, создание, хранение
 * и работа с каталогом пользователей и их банковских счетов
 *  * @author ALEXANDER EMELYANOV
 * @version 1.0
 */
public class BankService {
    /**
     * Поле ассоциативный массив пользователей
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавление пользователей в массив пользователей
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавления банковского счета пользователю
     * @param passport номер паспорта
     * @param account счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод поиска пользователя в массиве пользователей по номеру паспорта
     * @param passport номер паспорта
     * @return пользователь
     */
    public Optional<User> findByPassport(String passport) {
        return  users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод поиска счета пользователя по реквизитам счета и номеру паспорта пользователя
     * @param passport номер паспорта
     * @param requisite номер реквизита банковского счета
     * @return
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод перевода денег со счета источника на счет получателя
     * @param srcPassport номер паспорта источника
     * @param srcRequisite номер реквизита банковского счета источника
     * @param destPassport номер паспорта получателя
     * @param destRequisite номер реквизита банковского счета получателя
     * @param amount сумма перевода
     * @return булево значение выполнения операции
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}