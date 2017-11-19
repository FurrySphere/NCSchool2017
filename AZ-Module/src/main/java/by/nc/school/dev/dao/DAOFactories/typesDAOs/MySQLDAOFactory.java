package by.nc.school.dev.dao.DAOFactories.typesDAOs;

import by.nc.school.dev.dao.DAOFactories.AbstractDAOFactory;
import by.nc.school.dev.dao.DAOFactories.mySQLDAO.*;
import by.nc.school.dev.dao.DAOInterfacesEntities.*;

import java.sql.*;

public class MySQLDAOFactory extends AbstractDAOFactory {
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/students";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static UserDAO userDaoInstance;
    private static StudentDAO studentDaoInstance;
    private static ProfessorDAO professorDaoInstance;
    private static DepartmentDAO departmentDaoInstance;
    private static GroupDAO groupDaoInstance;
    private static SubjectDAO subjectDaoInstance;
    private static StatisticsDAO statisticsDaoInstance;

    private void createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public UserDAO getUserDAO() {
        synchronized (UserDAO.class) {
            if (userDaoInstance == null) {
                MySQLUserDAO userDao = new MySQLUserDAO();
                userDaoInstance = userDao;
            }
        }
        return userDaoInstance;
    }

    public StudentDAO getStudentDAO() {
        synchronized (StudentDAO.class) {
            if (studentDaoInstance == null) {
                MySQLStudentDAO studentDAO = new MySQLStudentDAO();
                studentDaoInstance = studentDAO;
            }
        }
        return studentDaoInstance;
    }

    public ProfessorDAO getProfessorDAO() {
        synchronized (ProfessorDAO.class) {
            if (professorDaoInstance == null) {
                MySQLProfessorDAO professorDAO = new MySQLProfessorDAO();
                professorDaoInstance = professorDAO;
            }
        }
        return professorDaoInstance;
        
    }

    public SubjectDAO getSubjectDAO() {
        synchronized (SubjectDAO.class) {
            if (subjectDaoInstance == null) {
                MySQLSubjectDAO subjectDAO = new MySQLSubjectDAO();
                subjectDaoInstance = subjectDAO;
            }
        }
        return subjectDaoInstance;
    }

    public StatisticsDAO getStatisticsDAO() {
        synchronized (StatisticsDAO.class) {
            if (statisticsDaoInstance == null) {
                MySQLStatisticsDAO statisticsDAO = new MySQLStatisticsDAO();
                statisticsDaoInstance = statisticsDAO;
            }
        }
        return statisticsDaoInstance;
    }

    public GroupDAO getGroupDAO() {
        synchronized (GroupDAO.class) {
            if (groupDaoInstance == null) {
                MySQLGroupDAO groupDAO = new MySQLGroupDAO();
                groupDaoInstance = groupDAO;
            }
        }
        return groupDaoInstance;
    }

    public DepartmentDAO getDepartmentDAO() {
        synchronized (StudentDAO.class) {
            if (departmentDaoInstance == null) {
                MySQLDepartmentDAO departmentDAO = new MySQLDepartmentDAO();
                departmentDaoInstance = departmentDAO;
            }
        }
        return departmentDaoInstance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        createConnection();
        return connection;
    }
}
