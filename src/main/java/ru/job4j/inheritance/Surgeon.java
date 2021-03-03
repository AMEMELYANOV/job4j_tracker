package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String assistantName;

    public Surgeon() {

    }

    public Surgeon(String name, String surname, String education,
                   String birthday, String specialization, String assistantName) {
        super(name, surname, education, birthday, specialization);
        this.assistantName = assistantName;
    }

    public Operation carryOutTheOperation(Pacient pacient) {
        return new Operation();
    }
}
