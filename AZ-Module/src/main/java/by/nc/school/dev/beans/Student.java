package by.nc.school.dev.beans;

import by.nc.school.dev.beans.additionalClasses.Address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Admin
 * @version 1.0
 */
public class Student extends User implements Serializable {
    private int courseNumber;
    private double averageScore;
    private List<Subject> listStudentSubjectsStudy;
    private long numberRecordBook;
    private HashMap<Subject, List<Integer>> studentIndebtedness;
    private HashMap<Subject, List<Integer>> studentMarks;

    public Student() {
    }

    public Student(int courseNumber, double averageScore, List<Subject> listStudentSubjectsStudy, long numberRecordBook,
                   HashMap<Subject, List<Integer>> studentIndebtedness, HashMap<Subject, List<Integer>> studentMarks) {
        this.courseNumber = courseNumber;
        this.averageScore = averageScore;
        this.listStudentSubjectsStudy = new ArrayList<Subject>(listStudentSubjectsStudy);
        this.numberRecordBook = numberRecordBook;
        this.studentIndebtedness = new HashMap<Subject, List<Integer>>(studentIndebtedness);
        this.studentMarks = new HashMap<Subject, List<Integer>>(studentMarks);
    }

    public Student(String surname, String name, String email, String telephoneNumber, int courseNumber,
                   double averageScore, List<Subject> listStudentSubjectsStudy, long numberRecordBook,
                   HashMap<Subject, List<Integer>> studentIndebtedness, HashMap<Subject, List<Integer>> studentMarks) {
        super(surname, name, email, telephoneNumber);
        this.courseNumber = courseNumber;
        this.averageScore = averageScore;
        this.listStudentSubjectsStudy = new ArrayList<Subject>(listStudentSubjectsStudy);
        this.numberRecordBook = numberRecordBook;
        this.studentIndebtedness = new HashMap<Subject, List<Integer>>(studentIndebtedness);
        this.studentMarks = new HashMap<Subject, List<Integer>>(studentMarks);
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Subject> getListStudentSubjectsStudy() {
        return listStudentSubjectsStudy;
    }

    public void setListStudentSubjectsStudy(List<Subject> listStudentSubjectsStudy) {
        this.listStudentSubjectsStudy = new ArrayList<Subject>(listStudentSubjectsStudy);
    }

    public long getNumberRecordBook() {
        return numberRecordBook;
    }

    public void setNumberRecordBook(long numberRecordBook) {
        this.numberRecordBook = numberRecordBook;
    }

    public HashMap<Subject, List<Integer>> getStudentIndebtedness() {
        return studentIndebtedness;
    }

    public void setStudentIndebtedness(HashMap<Subject, List<Integer>> studentIndebtedness) {
        this.studentIndebtedness = new HashMap<Subject, List<Integer>>(studentIndebtedness);
    }

    public HashMap<Subject, List<Integer>> getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(HashMap<Subject, List<Integer>> studentMarks) {
        this.studentMarks = new HashMap<Subject, List<Integer>>(studentMarks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (courseNumber != student.courseNumber) return false;
        if (Double.compare(student.getAverageScore(), getAverageScore()) != 0) return false;
        if (getNumberRecordBook() != student.getNumberRecordBook()) return false;
        if (!getListStudentSubjectsStudy().equals(student.getListStudentSubjectsStudy())) return false;
        if (getStudentIndebtedness() != null ? !getStudentIndebtedness().equals(student.getStudentIndebtedness()) : student.getStudentIndebtedness() != null)
            return false;
        return getStudentMarks().equals(student.getStudentMarks());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + courseNumber;
        temp = Double.doubleToLongBits(getAverageScore());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getListStudentSubjectsStudy().hashCode();
        result = 31 * result + (int) (getNumberRecordBook() ^ (getNumberRecordBook() >>> 32));
        result = 31 * result + (getStudentIndebtedness() != null ? getStudentIndebtedness().hashCode() : 0);
        result = 31 * result + getStudentMarks().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "courseNumber=" + courseNumber +
                ", averageScore=" + averageScore +
                ", listStudentSubjectsStudy=" + listStudentSubjectsStudy +
                ", numberRecordBook=" + numberRecordBook +
                ", studentIndebtedness=" + studentIndebtedness +
                ", studentMarks=" + studentMarks +
                '}';
    }
}