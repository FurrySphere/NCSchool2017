package by.nc.school.dev.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Admin
 * @version 1.0
 */
public class Professor extends User implements Serializable {
    private List<Subject> listSubjectsProfessorTeach;
    private String scienceDegree;

    public Professor() {
    }

    public Professor(List<Subject> listSubjectsProfessorTeach, String scienceDegree) {
        this.listSubjectsProfessorTeach = new ArrayList<Subject>(listSubjectsProfessorTeach);
        this.scienceDegree = scienceDegree;
    }

    public Professor(String surname, String name, String email, String telephoneNumber,
                     List<Subject> listSubjectsProfessorTeach, String scienceDegree) {
        super(surname, name, email, telephoneNumber);
        this.listSubjectsProfessorTeach = new ArrayList<Subject>(listSubjectsProfessorTeach);
        this.scienceDegree = scienceDegree;
    }

    public List<Subject> getListSubjectsProfessorTeach() {
        return listSubjectsProfessorTeach;
    }

    public void setListSubjectsProfessorTeach(List<Subject> listSubjectsProfessorTeach) {
        this.listSubjectsProfessorTeach = new ArrayList<Subject>(listSubjectsProfessorTeach);
    }

    public String getScienceDegree() {
        return scienceDegree;
    }

    public void setScienceDegree(String scienceDegree) {
        this.scienceDegree = scienceDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Professor professor = (Professor) o;

        if (!getListSubjectsProfessorTeach().equals(professor.getListSubjectsProfessorTeach())) return false;
        return getScienceDegree().equals(professor.getScienceDegree());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getListSubjectsProfessorTeach().hashCode();
        result = 31 * result + getScienceDegree().hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < listSubjectsProfessorTeach.size(); i++) {
            builder.append(listSubjectsProfessorTeach.get(i)).append(" ");
        }
        return "Professor{" +
                "listSubjectsProfessorTeach: " + builder.toString() + "\n" +
                "scienceDegree = " + scienceDegree + "\n" +
                '}';
    }
}