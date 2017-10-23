package by.nc.school.dev.dao.DAOInterfacesEntities;

import by.nc.school.dev.beans.Student;
import by.nc.school.dev.beans.Subject;

import java.util.List;

public interface StudentDAO {
    public int addStudent();
    //public boolean deleteStudent();
    public Student findStudent();
    public boolean editStudent();
    public boolean showStudentProfile();
    public double getCoefficientScholarship();
    public List<Subject> getListLearningSubjects();
}
