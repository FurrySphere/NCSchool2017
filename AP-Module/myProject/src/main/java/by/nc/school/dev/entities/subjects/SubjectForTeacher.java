package main.java.by.nc.school.dev.entities.subjects;

import main.java.by.nc.school.dev.entities.users.Student;

import java.util.ArrayList;

/**
 * Created by User on 15.10.2017.
 */
public class SubjectForTeacher extends Subject{
    ArrayList<Student> listOfStudents;

    public SubjectForTeacher(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectForTeacher that = (SubjectForTeacher) o;

        return listOfStudents.equals(that.listOfStudents);
    }

    @Override
    public int hashCode() {
        return listOfStudents.hashCode();
    }

    @Override
    public String toString() {
        return "SubjectForTeacher{" + "name" + getName() +
                "listOfStudents=" + listOfStudents +
                '}';
    }
}
