package ru.job4j.oop;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle bus1 = new Bus("Bus1");
        Vehicle bus2 = new Bus("Bus2");
        Vehicle airplane1 = new Airplane("Airplane1");
        Vehicle airplane2 = new Airplane("Airplane2");
        Vehicle train1 = new Train("Train1");
        Vehicle train2 = new Train("Train2");
        Vehicle[] arrVehicle = new Vehicle[6];
        arrVehicle[0] = bus1;
        arrVehicle[1] = bus2;
        arrVehicle[2] = airplane1;
        arrVehicle[3] = airplane2;
        arrVehicle[4] = train1;
        arrVehicle[5] = train2;
        for (int i = 0; i < arrVehicle.length; i++) {
            System.out.println(arrVehicle[i].getName());
            arrVehicle[i].refueling();
            arrVehicle[i].move();
        }
    }
}
