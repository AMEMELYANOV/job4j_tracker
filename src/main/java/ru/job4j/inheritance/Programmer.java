package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String languageOfProgramming;

    public Programmer() {

    }

    public Programmer(String name, String surname, String education,
                      String birthday, String category, String languageOfProgramming) {
        super(name, surname, education, birthday, category);
        this.languageOfProgramming = languageOfProgramming;
    }

    public Code getCode(Task task) {
        return new Code();
    }
}
