package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Ivanovich");
        student.setGroup(1);
        student.setReceiptDate("13.02.2021");
        System.out.println(student.getFullName());
        System.out.println(student.getGroup());
        System.out.println(student.getReceiptDate());
    }
}
