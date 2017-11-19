package by.nc.school.dev.model.beans;

import java.util.List;
import java.util.Map;

public class Journal {

    private int id;

    private int groupID;

    private Map<Student, List<Mark>> marksOfStudents;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public Map<Student, List<Mark>> getMarksOfStudents() {
        return marksOfStudents;
    }

    public void setMarksOfStudents(Map<Student, List<Mark>> marksOfStudents) {
        this.marksOfStudents = marksOfStudents;
    }
}
