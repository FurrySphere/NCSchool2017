package by.nc.school.dev.dao.DAOFactories;

import by.nc.school.dev.dao.DAOFactories.typesDAOFactories.ConsoleDAOFactory;
import by.nc.school.dev.dao.DAOFactories.typesDAOFactories.MySQLDAOFactory;
import by.nc.school.dev.dao.DAOFactories.typesDAOFactories.TextFileDAOFactory;
import by.nc.school.dev.dao.DAOInterfacesEntities.*;

public abstract class DAOFactory {
    // List of types DAO
    private static final int MYSQL = 1;
    private static final int CONSOLE = 2;
    private static final int TEXT_FILE = 3;

    // Здесь будет метод для каждого DAO, который может быть создан. Реализовывать эти методы должны
    // конкретные генераторы.
    public abstract UserDAO getUserDAO();
    public abstract StudentDAO getStudentDAO();
    public abstract ProfessorDAO getProfessorDAO();
    public abstract SubjectDAO getSubjectDAO();
    public abstract StatisticsDAO getStatisticsDAO();
    public abstract DepartmentDAO getDepartmentDAO();
    public abstract GroupDAO getGroupDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new MySQLDAOFactory();
            case CONSOLE:
                return new ConsoleDAOFactory();
            case TEXT_FILE:
                return new TextFileDAOFactory();

            default:
                return null;
        }
    }
}
