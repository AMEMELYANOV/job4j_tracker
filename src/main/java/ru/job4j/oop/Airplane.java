package ru.job4j.oop;

public class Airplane implements Vehicle{
    private String name;

    public Airplane(){}

    public Airplane(String name){this.name = name;}

    @Override
    public String getName() {return name;}

    @Override
    public void move() {
        System.out.println("Airplane is moving");
    }

    @Override
    public void refueling() {
        System.out.println("Airplane is refueling with kerosene");
    }
}
