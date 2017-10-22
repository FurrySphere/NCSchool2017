package by.nc.school.dev.entities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kirlev on 10/22/17.
 */
public class Student extends User  {
    private int year;
    private StudentsGroup group;
    private double averageScore;
    private ArrayList<Subject> subjects;
    private HashMap<Subject, ArrayList<Integer>> listOfGrades;



}
