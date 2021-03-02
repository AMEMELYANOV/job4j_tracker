package ru.job4j.poly;

public class BusTest {
    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.go();
        bus.passengers(100);
        System.out.println(bus.fill(20.50));

        bus = new Bus(50.0);
        bus.go();
        bus.passengers(100);
        System.out.println(bus.fill(20.50));
    }
}
