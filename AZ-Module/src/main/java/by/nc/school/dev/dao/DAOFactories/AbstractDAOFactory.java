package by.nc.school.dev.dao.DAOFactories;

import by.nc.school.dev.dao.DAOFactories.typesDAOs.MySQLDAOFactory;
import by.nc.school.dev.dao.DAOInterfacesEntities.*;

public abstract class AbstractDAOFactory {
    // List of types DAO
    private static final int MYSQL = 1;
    private static final int TEXT_FILE = 2;

    public abstract UserDAO getUserDAO();
    public abstract StudentDAO getStudentDAO();
    public abstract ProfessorDAO getProfessorDAO();
    public abstract SubjectDAO getSubjectDAO();
    public abstract StatisticsDAO getStatisticsDAO();
    public abstract DepartmentDAO getDepartmentDAO();
    public abstract GroupDAO getGroupDAO();

    public static AbstractDAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new MySQLDAOFactory();
            //case TEXT_FILE:
                //return new TextFileDAO();
            default:
                return null;
        }
    }
}
