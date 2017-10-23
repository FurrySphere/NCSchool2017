package by.nc.school.dev.dao.DAOFactories.typesDAOFactories;

import by.nc.school.dev.dao.DAOFactories.DAOFactory;
import by.nc.school.dev.dao.DAOFactories.textFileDAOFactory.TextFileProfessorDAO;
import by.nc.school.dev.dao.DAOFactories.textFileDAOFactory.TextFileStudentDAO;
import by.nc.school.dev.dao.DAOFactories.textFileDAOFactory.TextFileUserDAO;
import by.nc.school.dev.dao.DAOInterfacesEntities.*;

public class TextFileDAOFactory extends DAOFactory {
    public UserDAO getUserDAO() {
        return new TextFileUserDAO();
    }

    public StudentDAO getStudentDAO() {
        return new TextFileStudentDAO();
    }

    public ProfessorDAO getProfessorDAO() {
        return new TextFileProfessorDAO();
    }

    public SubjectDAO getSubjectDAO() {
        return null;
    }

    public StatisticsDAO getStatisticsDAO() {
        return null;
    }

    public DepartmentDAO getDepartmentDAO() {
        return null;
    }

    public GroupDAO getGroupDAO() {
        return null;
    }
}
