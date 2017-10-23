package main.java.by.nc.school.dev.entities;

import java.util.List;
import java.util.Objects;

/**
 * Created by admin.
 */
public class Faculty {
    private String facultyName;
    private List<Department> departmentList;
    private List<Specialty> specialtyList;

    public Faculty() {
    }

    public Faculty(String facultyName, List<Department> departmentList, List<Specialty> specialtyList) {
        this.facultyName = facultyName;
        this.departmentList = departmentList;
        this.specialtyList = specialtyList;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Specialty> getSpecialtyList() {
        return specialtyList;
    }

    public void setSpecialtyList(List<Specialty> specialtyList) {
        this.specialtyList = specialtyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(facultyName, faculty.facultyName) &&
                Objects.equals(departmentList, faculty.departmentList) &&
                Objects.equals(specialtyList, faculty.specialtyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyName, departmentList, specialtyList);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName='" + facultyName + '\'' +
                ", departmentList=" + departmentList +
                ", specialtyList=" + specialtyList +
                '}';
    }
    //private List<>

}
