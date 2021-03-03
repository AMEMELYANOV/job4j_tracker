package ru.job4j.oop;

public class Train implements Vehicle {
    private String name;

    public Train() {

    }

    public Train(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void move() {
        System.out.println("Train is moving on rails");
    }

    @Override
    public void refueling() {
        System.out.println("Train is refueling with diesel");
    }
}
