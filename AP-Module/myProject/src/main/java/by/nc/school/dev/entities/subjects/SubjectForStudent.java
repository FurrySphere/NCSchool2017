package main.java.by.nc.school.dev.entities.subjects;

import java.util.Date;

/**
 * Created by User on 15.10.2017.
 */
public class SubjectForStudent extends Subject{
    private String nameOfTeacher;
    private Date date;
    private float mark;

    public SubjectForStudent(String name, String nameOfTeacher, Date date, float mark) {
        setName(name);
        this.nameOfTeacher = nameOfTeacher;
        this.date = date;
        this.mark = mark;
    }

    public String getNameOfTeacher() {
        return nameOfTeacher;
    }

    public void setNameOfTeacher(String nameOfTeacher) {
        this.nameOfTeacher = nameOfTeacher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectForStudent that = (SubjectForStudent) o;

        if (Float.compare(that.mark, mark) != 0) return false;
        if (!nameOfTeacher.equals(that.nameOfTeacher)) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = nameOfTeacher.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + (mark != +0.0f ? Float.floatToIntBits(mark) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SubjectForStudent{" + "name" +getName() +
                "nameOfTeacher='" + nameOfTeacher + '\'' +
                ", date=" + date +
                ", mark=" + mark +
                '}';
    }
}
