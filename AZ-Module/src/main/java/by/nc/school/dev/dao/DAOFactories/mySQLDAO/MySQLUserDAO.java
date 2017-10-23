package by.nc.school.dev.dao.DAOFactories.mySQLDAO;

import by.nc.school.dev.beans.User;
import by.nc.school.dev.dao.DAOInterfacesEntities.UserDAO;

import java.util.List;

public class MySQLUserDAO implements UserDAO {
    public User addUser(String[] userArray) {
        return null;
    }

    public boolean findUser(User user, List<User> usersList) {
        return false;
    }

    public List<User> editUser(User editingUser, User oldUser, List<User> usersList) {
        return null;
    }

    public boolean doLogin(User user) {
        return false;
    }
}
