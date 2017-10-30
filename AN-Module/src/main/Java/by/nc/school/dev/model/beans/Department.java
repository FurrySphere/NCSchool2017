package by.nc.school.dev.model.beans;

import java.util.List;

public class Department {

    List<Teacher> teacherList;
    List<Discipline> profDisciplineList;


    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Discipline> getProfDisciplineList() {
        return profDisciplineList;
    }

    public void setProfDisciplineList(List<Discipline> profDisciplineList) {
        this.profDisciplineList = profDisciplineList;
    }
}
