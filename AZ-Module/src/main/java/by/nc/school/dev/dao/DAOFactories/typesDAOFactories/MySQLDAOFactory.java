package by.nc.school.dev.dao.DAOFactories.typesDAOFactories;

import by.nc.school.dev.dao.DAOFactories.DAOFactory;
import by.nc.school.dev.dao.DAOFactories.mySQLDAO.*;
import by.nc.school.dev.dao.DAOInterfacesEntities.*;

import java.sql.*;

public class MySQLDAOFactory extends DAOFactory {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private static final String URL = "jdbc:mysql://localhost:3306/students";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    private void createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        statement = connection.createStatement();
    }

    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    public StudentDAO getStudentDAO() {
        return new MySQLStudentDAO();
    }

    public ProfessorDAO getProfessorDAO() {
        return new MySQLProfessorDAO();
    }

    public SubjectDAO getSubjectDAO() {
        return new MySQLSubjectDAO();
    }

    public StatisticsDAO getStatisticsDAO() {
        return new MySQLStatisticsDAO();
    }

    public DepartmentDAO getDepartmentDAO() {
        return new MySQLDepartmentDAO();
    }

    public GroupDAO getGroupDAO() {
        return new MySQLGroupDAO();
    }
}
