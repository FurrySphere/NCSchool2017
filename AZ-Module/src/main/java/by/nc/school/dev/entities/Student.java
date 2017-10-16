package by.nc.school.dev.beans;

import by.nc.school.dev.beans.additionalClasses.Address;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Admin
 * @version 1.0
 */
public class Student extends Human {
    private double averageScore;
    private List<Subject> listStudentSubjectsStudy;
    private long numberRecordBook;
    private HashMap<Subject, List<Integer>> studentIndebtedness;
    private HashMap<Subject, List<Integer>> studentMarks;

    public Student() {
    }

    public Student(double averageScore, List<Subject> listStudentSubjectsStudy, long numberRecordBook,
                   HashMap<Subject, List<Integer>> studentIndebtedness, HashMap<Subject, List<Integer>> studentMarks) {
        this.averageScore = averageScore;
        this.listStudentSubjectsStudy = new ArrayList<Subject>(listStudentSubjectsStudy);
        this.numberRecordBook = numberRecordBook;
        this.studentIndebtedness = new HashMap<Subject, List<Integer>>(studentIndebtedness);
        this.studentMarks = new HashMap<Subject, List<Integer>>(studentMarks);
    }

    public Student(String surname, String name, String email, Address address, String telephoneNumber,
                   double averageScore, List<Subject> listStudentSubjectsStudy, long numberRecordBook,
                   HashMap<Subject, List<Integer>> studentIndebtedness, HashMap<Subject, List<Integer>> studentMarks) {
        super(surname, name, email, address, telephoneNumber);
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

        if (Double.compare(student.getAverageScore(), getAverageScore()) != 0) return false;
        if (getNumberRecordBook() != student.getNumberRecordBook()) return false;
        if (!getListStudentSubjectsStudy().equals(student.getListStudentSubjectsStudy())) return false;
        if (getStudentIndebtedness() != null ? !getStudentIndebtedness().equals(student.getStudentIndebtedness()) : student.getStudentIndebtedness() != null)
            return false;
        return getStudentMarks() != null ? getStudentMarks().equals(student.getStudentMarks()) : student.getStudentMarks() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getAverageScore());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getListStudentSubjectsStudy().hashCode();
        result = 31 * result + (int) (getNumberRecordBook() ^ (getNumberRecordBook() >>> 32));
        result = 31 * result + (getStudentIndebtedness() != null ? getStudentIndebtedness().hashCode() : 0);
        result = 31 * result + (getStudentMarks() != null ? getStudentMarks().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builderStudentSubjectsStudy = new StringBuilder();
        for (int i = 0; i < listStudentSubjectsStudy.size(); i++) {
            builderStudentSubjectsStudy.append(listStudentSubjectsStudy.get(i)).append(" ");
        }

        return "Student{" +
                "averageScore=" + averageScore + "\n" +
                "listStudentSubjectsStudy=" + listStudentSubjectsStudy + "\n" +
                "numberRecordBook=" + numberRecordBook + "\n" +
                '}';
    }
}