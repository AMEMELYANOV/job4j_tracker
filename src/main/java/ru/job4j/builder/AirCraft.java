package ru.job4j.builder;

public class AirCraft {
        private String type;
        private String model;
        private double speed;
        private int yearOfProduction;
        private int numbersOfPassengers;
        private String airportRegister;
        private byte numberOfEngines;
        private int range;

    @Override
    public String toString() {
        return "AirCraft{"
                + "type = '" + type + '\''
                + ", model = '" + model + '\''
                + ", speed = " + speed
                + ", yearOfProduction = " + yearOfProduction
                + ", numbersOfPassengers = " + numbersOfPassengers
                + ", airportRegister = '" + airportRegister + '\''
                + ", numberOfEngines = " + numberOfEngines
                + ", range = " + range
                + '}';
    }

    static class Builder {
        private String type;
        private String model;
        private double speed;
        private int yearOfProduction;
        private int numbersOfPassengers;
        private String airportRegister;
        private byte numberOfEngines;
        private int range;

        public Builder buildType(String type) {
            this.type = type;
            return this;
        }

        public Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        public Builder buildSpeed(double speed) {
            this.speed = speed;
            return this;
        }

        public Builder buildYearOfProduction(int yearOfProduction) {
            this.yearOfProduction = yearOfProduction;
            return this;
        }

        public Builder buildNumbersOfPassengers(int numbersOfPassengers) {
            this.numbersOfPassengers = numbersOfPassengers;
            return this;
        }

        public Builder buildAirportRegister(String airportRegister) {
            this.airportRegister = airportRegister;
            return this;
        }

        public Builder buildNumberOfEngines(byte numberOfEngines) {
            this.numberOfEngines = numberOfEngines;
            return this;
        }

        public Builder buildRange(int range) {
            this.range = range;
            return this;
        }

        AirCraft build() {
            AirCraft airCraft = new AirCraft();
            airCraft.type = type;
            airCraft.model = model;
            airCraft.speed = speed;
            airCraft.yearOfProduction = yearOfProduction;
            airCraft.numbersOfPassengers = numbersOfPassengers;
            airCraft.airportRegister = airportRegister;
            airCraft.numberOfEngines = numberOfEngines;
            airCraft.range = range;
            return airCraft;
        }
    }

    public static void main(String[] args) {
        AirCraft airCraft = new Builder()
                .buildType("passenger")
                .buildModel("AirBus 320")
                .buildSpeed(840)
                .buildYearOfProduction(1986)
                .buildNumbersOfPassengers(180)
                .buildAirportRegister("Heathrow")
                .buildNumberOfEngines((byte) 2)
                .buildRange(5000)
                .build();
        System.out.println(airCraft);
    }
}
