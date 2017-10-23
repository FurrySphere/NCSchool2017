package main.java.by.nc.school.dev.entities;

import java.util.List;
import java.util.Objects;

/**
 * Created by admin.
 */
public class Specialty {
    private String specialtyName;
    private List<Course> courseList;

    public Specialty() {
    }

    public Specialty(String specialtyName, List<Course> courseList) {
        this.specialtyName = specialtyName;
        this.courseList = courseList;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty = (Specialty) o;
        return Objects.equals(specialtyName, specialty.specialtyName) &&
                Objects.equals(courseList, specialty.courseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialtyName, courseList);
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "specialtyName='" + specialtyName + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
