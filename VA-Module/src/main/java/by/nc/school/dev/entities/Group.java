package main.java.by.nc.school.dev.entities;

import java.util.List;
import java.util.Objects;

/**
 * Created by admin.
 */
public class Group {

    private int groupNumber;
    private List<Student> studentList;
    private List<Subject> subjectList;

    public Group() {
    }

    public Group(int groupNumber, List<Student> studentList, List<Subject> subjectList) {
        this.groupNumber = groupNumber;
        this.studentList = studentList;
        this.subjectList = subjectList;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupNumber == group.groupNumber &&
                Objects.equals(studentList, group.studentList) &&
                Objects.equals(subjectList, group.subjectList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNumber, studentList, subjectList);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber=" + groupNumber +
                ", studentList=" + studentList +
                ", subjectList=" + subjectList +
                '}';
    }
}
