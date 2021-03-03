package ru.job4j.poly;

public class Bus implements Transport {
    private double fuelPrice = 45.50;

    public Bus() { }

    public Bus(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    @Override
    public void go() {
        System.out.println("Bus is going");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Number of passengers - " + number);
    }

    @Override
    public double fill(double fuelQuantity) {
        return fuelQuantity * this.fuelPrice;
    }
}

