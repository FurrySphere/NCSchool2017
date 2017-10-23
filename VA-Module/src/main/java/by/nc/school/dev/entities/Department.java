package main.java.by.nc.school.dev.entities;

import java.util.List;
import java.util.Objects;

/**
 * Created by admin.
 */
public class Department {
    private String departmentName;
    private List<Lecturer> lecturerList;

    public Department() {
    }

    public Department(String departmentName, List<Lecturer> lecturerList) {
        this.departmentName = departmentName;
        this.lecturerList = lecturerList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Lecturer> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(List<Lecturer> lecturerList) {
        this.lecturerList = lecturerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(lecturerList, that.lecturerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, lecturerList);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", lecturerList=" + lecturerList +
                '}';
    }
    // private List<Group> groupList;
}
