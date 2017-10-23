package by.nc.school.dev.dao.DAOFactories.textFileDAOFactory;

import by.nc.school.dev.beans.Student;
import by.nc.school.dev.beans.Subject;
import by.nc.school.dev.dao.DAOInterfacesEntities.StudentDAO;

import java.util.List;

public class TextFileStudentDAO implements StudentDAO {
    public int addStudent() {
        return 0;
    }

    public Student findStudent() {
        return null;
    }

    public boolean editStudent() {
        return false;
    }

    public boolean showStudentProfile() {
        return false;
    }

    public double getCoefficientScholarship() {
        return 0;
    }

    public List<Subject> getListLearningSubjects() {
        return null;
    }
}
