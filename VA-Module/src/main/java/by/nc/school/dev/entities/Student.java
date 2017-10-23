package main.java.by.nc.school.dev.entities;

import java.util.List;
import java.util.Map;

/**
 * Created by admin.
 */
public class Student extends User {
    //private List<Subject> subjectList;
    private Map<Subject, List<Integer>> listMarks;


    public Student(long id, String firstName, String middleName, String lastName, String login, String password) {
        super(id, firstName, middleName, lastName, login, password);
    }

    public Student(String firstName, String middleName, String lastName) {
        super(firstName, middleName, lastName);
    }
}
