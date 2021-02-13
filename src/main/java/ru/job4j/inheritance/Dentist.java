package ru.job4j.inheritance;

public class Dentist extends Doctor{

    private boolean isChildren;

    public Dentist() {

    }

    public Dentist(String name, String surname, String education, String birthday, String specialization, boolean isChildren) {
        super(name, surname, education, birthday, specialization);
        this.isChildren = isChildren;
    }

    public Tooth toTreatTooth(Pacient pacient){
        return new Tooth();

    }
}
