package ru.job4j.inheritance;

public class Builder extends Engineer{

    private String currentWork;

    public Builder(){

    }

    public Builder(String name, String surname, String education, String birthday, String category, String currentWork) {
        super(name, surname, education, birthday, category);
        this.currentWork = currentWork;
    }

    public Building doBuilding(Task task) {
        return new Building();
    }
}
