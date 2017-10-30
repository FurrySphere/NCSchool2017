package by.nc.school.dev.model.beans;

public class Teacher {

    private final Discipline discipline;

    public Teacher(Discipline discipline) {
        this.discipline = discipline;
    }

    public Discipline getDiscipline() {
        return discipline;
    }
}
