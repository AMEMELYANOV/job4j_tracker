package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 100);
        Book book2 = new Book("Three Musketeers", 753);
        Book book3 = new Book("Count of Monte Cristo", 551);
        Book book4 = new Book("Forty five", 437);
        Book[] arrayBook = new Book[]{book1, book2, book3, book4};
        for (int i = 0; i < arrayBook.length; i++) {
            System.out.println(arrayBook[i].getName() + " - " + arrayBook[i].getNumberOfPage());
        }
        Book temp = arrayBook[0];
        arrayBook[0] = arrayBook[3];
        arrayBook[3] = temp;
        for (int i = 0; i < arrayBook.length; i++) {
            System.out.println(arrayBook[i].getName() + " - " + arrayBook[i].getNumberOfPage());
        }
        for (int i = 0; i < arrayBook.length; i++) {
            if (arrayBook[i].getName().equals("Clean code")) {
                System.out.println(arrayBook[i].getName() + " - " + arrayBook[i].getNumberOfPage());
            }
        }
    }
}
