package by.nc.school.dev;

import by.nc.school.dev.user.Student;
import by.nc.school.dev.user.Tutor;

import java.util.List;
import java.util.Map;

public class Group {

    private int groupNumber;
    private int groupId;
    private List<Student> students;
    private Tutor curator;

    public int getGroupNumber() {
        return groupNumber;
    }

    public int getGroupId() {
        return groupId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Tutor getCurator() {
        return curator;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber=" + groupNumber +
                ", groupId=" + groupId +
                ", students=" + students +
                ", curator=" + curator +
                '}';
    }
}
