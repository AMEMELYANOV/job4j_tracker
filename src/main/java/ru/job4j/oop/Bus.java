package ru.job4j.oop;

public class Bus implements Vehicle{

    private String name;

    public Bus(){}

    public Bus(String name){this.name = name;}

    @Override
    public String getName() {return name;}

    @Override
    public void move() {
        System.out.println("Bus is driving on the highway");
    }

    @Override
    public void refueling() {
        System.out.println("Bus is refueling with gasoline");
    }
}
