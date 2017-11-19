package main.java.by.nc.school.dev.entities;

import java.util.Objects;

/**
 * Created by admin.
 */
public class Subject {
    private String name;
    private boolean isExam;
    private Lecturer lecturer;

    public Subject() {
    }

    public Subject(String name, boolean isExam, Lecturer lecturer) {
        this.name = name;
        this.isExam = isExam;
        this.lecturer = lecturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExam() {
        return isExam;
    }

    public void setExam(boolean exam) {
        isExam = exam;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return isExam == subject.isExam &&
                Objects.equals(name, subject.name) &&
                Objects.equals(lecturer, subject.lecturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isExam, lecturer);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", isExam=" + isExam +
                ", lecturer=" + lecturer +
                '}';
    }
}
