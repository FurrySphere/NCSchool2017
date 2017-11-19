package main.java.by.nc.school.dev.entities;


import java.util.List;

/**
 * Created by admin.
 */
public class Lecturer extends User {
    private List<Subject> subjectList;

    public Lecturer(long id, String firstName, String middleName, String lastName, String login, String password) {
        super(id, firstName, middleName, lastName, login, password);
    }

    public Lecturer(String firstName, String middleName, String lastName) {
        super(firstName, middleName, lastName);
    }
}
