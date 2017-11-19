package by.nc.school.dev.dao.DAOFactories.mySQLDAO;

import by.nc.school.dev.beans.User;
import by.nc.school.dev.beans.enums.Role;
import by.nc.school.dev.dao.DAOFactories.typesDAOs.MySQLDAOFactory;
import by.nc.school.dev.dao.DAOInterfacesEntities.UserDAO;
import by.nc.school.dev.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAO implements UserDAO {
    //protected UserDAO userDAO;
    private static final String ALL_USERS   = "SELECT * FROM users;";
    private static final String ADD_USER    = "INSERT INTO users (id, username, password, role_id, surname, name, email," +
            " telephone_number) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String USER_BY_ID  = "SELECT * FROM users WHERE id = ?;";
    private static final String UPDATE_USER = "UPDATE users SET username = ?, password = ?, role_id =?," +
            " surname = ?, name = ?, email = ?, telephone_number = ? WHERE id = ?;";
    //private static final String FIND_USER = "SELECT * FROM users WHERE username LIKE ?;";
    private static final String FIND_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?;";

    public boolean doLogin(User user) {
        return false;
    }

    public List<User> getListUsers() throws UserException {
        List<User> listUsers;
        //MySQLDAOFactory.getDAOFactory(1).getUserDAO();
        MySQLDAOFactory mySQLDAOFactory = new MySQLDAOFactory();
        mySQLDAOFactory.getUserDAO();
        try {
            Connection connection = mySQLDAOFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(ALL_USERS);
            ResultSet set = statement.executeQuery();
            listUsers = parseResultSet(set);
            connection.close();
        } catch (SQLException e) {
            throw new UserException(e);
        } catch (ClassNotFoundException e) {
            throw new UserException(e);
        }
        return listUsers;
    }

    public boolean addUser(User user) throws UserException {
        MySQLDAOFactory mySQLDAOFactory = new MySQLDAOFactory();
        mySQLDAOFactory.getUserDAO();
        try {
            Connection connection = mySQLDAOFactory.getConnection();
            //User user = new User();
            user.setId(getListUsers().size() + 1);
            PreparedStatement statement = connection.prepareStatement(ADD_USER);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole().ordinal());
            statement.setString(5, user.getSurname());
            statement.setString(6, user.getName());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getTelephoneNumber());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new UserException(e);
        } catch (ClassNotFoundException e) {
            throw new UserException(e);
        }
        return true;
    }

    public User getUserById(int id) throws UserException {
        MySQLDAOFactory mySQLDAOFactory = new MySQLDAOFactory();
        mySQLDAOFactory.getUserDAO();
        User user = new User();
        try {
            Connection connection = mySQLDAOFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(USER_BY_ID);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                user.setId(id);
                user.setUsername(set.getString("username"));
                user.setPassword(set.getString("password"));
                user.setRole(Role.getRoleById(set.getInt("role_id")));
                user.setSurname(set.getString("surname"));
                user.setName(set.getString("name"));
                user.setEmail(set.getString("email"));
                user.setTelephoneNumber(set.getString("telephone_number"));
            }
            connection.close();
        } catch (SQLException e) {
            throw new UserException(e);
        } catch (ClassNotFoundException e) {
            throw new UserException(e);
        }
        return user;
    }

    public User findUserByUsername(String username) throws UserException {
        User user = null;
        MySQLDAOFactory mySQLDAOFactory = new MySQLDAOFactory();
        mySQLDAOFactory.getUserDAO();

        try {
            Connection connection = mySQLDAOFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getLong("id"), resultSet.getString("username"),
                        resultSet.getString("password"), Role.getRoleById(resultSet.getInt("role_id")),
                        resultSet.getString("surname"), resultSet.getString("name"),
                        resultSet.getString("email"), resultSet.getString("telephone_number"));
            }
            connection.close();
        } catch (SQLException e) {
            throw new UserException(e);
        } catch (ClassNotFoundException e) {
            throw new UserException(e);
        }
        return user;
    }

    public void updateUser(User user) throws UserException {
        MySQLDAOFactory mySQLDAOFactory = new MySQLDAOFactory();
        mySQLDAOFactory.getUserDAO();
        try {
            Connection connection = mySQLDAOFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole().ordinal());
            statement.setString(5, user.getSurname());
            statement.setString(6, user.getName());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getTelephoneNumber());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new UserException(e);
        } catch (ClassNotFoundException e) {
            throw new UserException(e);
        }
    }

    private List<User> parseResultSet(ResultSet set) throws UserException {
        List<User> usersList = new ArrayList<User>();
        try {
            while (set.next()) {
                User user = new User();
                user.setId(set.getInt("id"));
                user.setUsername(set.getString("username"));
                user.setPassword(set.getString("password"));
                user.setRole(Role.getRoleById(set.getInt("role_id")));
                user.setSurname(set.getString("surname"));
                user.setName(set.getString("name"));
                user.setEmail(set.getString("email"));
                user.setTelephoneNumber(set.getString("telephone_number"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new UserException(e);
        }
        return usersList;
    }
}
