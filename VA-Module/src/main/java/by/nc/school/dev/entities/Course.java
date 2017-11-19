package main.java.by.nc.school.dev.entities;

import java.util.List;
import java.util.Objects;

/**
 * Created by admin.
 */
public class Course {
    private int courseNumber;
    private List<Group> groupList;

    public Course() {
    }

    public Course(int courseNumber, List<Group> groupList) {
        this.courseNumber = courseNumber;
        this.groupList = groupList;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseNumber == course.courseNumber &&
                Objects.equals(groupList, course.groupList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseNumber, groupList);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNumber=" + courseNumber +
                ", groupList=" + groupList +
                '}';
    }
}
