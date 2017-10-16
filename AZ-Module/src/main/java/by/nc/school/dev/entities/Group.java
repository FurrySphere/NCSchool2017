package by.nc.school.dev.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 * @version 1.0
 */
public class Group {
    private int groupNumber;
    private Professor groupProfessorCurator;
    private List<Student> listStudents;
    private Student praepostorGroupInfo;

    public Group() {
    }

    public Group(int groupNumber, Professor groupProfessorCurator, List<Student> listStudents, Student praepostorGroupInfo) {
        this.groupNumber = groupNumber;
        this.groupProfessorCurator = groupProfessorCurator;
        this.listStudents = new ArrayList<Student>(listStudents);
        this.praepostorGroupInfo = praepostorGroupInfo;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Professor getGroupProfessorCurator() {
        return groupProfessorCurator;
    }

    public void setGroupProfessorCurator(Professor groupProfessorCurator) {
        this.groupProfessorCurator = groupProfessorCurator;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = new ArrayList<Student>(listStudents);
    }

    public Student getPraepostorGroupInfo() {
        return praepostorGroupInfo;
    }

    public void setPraepostorGroupInfo(Student praepostorGroupInfo) {
        this.praepostorGroupInfo = praepostorGroupInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (getGroupNumber() != group.getGroupNumber()) return false;
        if (!getGroupProfessorCurator().equals(group.getGroupProfessorCurator())) return false;
        if (!getListStudents().equals(group.getListStudents())) return false;
        return getPraepostorGroupInfo().equals(group.getPraepostorGroupInfo());
    }

    @Override
    public int hashCode() {
        int result = getGroupNumber();
        result = 31 * result + getGroupProfessorCurator().hashCode();
        result = 31 * result + getListStudents().hashCode();
        result = 31 * result + getPraepostorGroupInfo().hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < listStudents.size(); i++) {
            builder.append(listStudents.get(i)).append(" ");
        }
        return "Group{" +
                "groupNumber=" + groupNumber + "\n" +
                "groupProfessorCurator=" + groupProfessorCurator + "\n" +
                "listStudents=" + builder.toString() + "\n" +
                "praepostorGroupInfo=" + praepostorGroupInfo + "\n" +
                '}';
    }
}