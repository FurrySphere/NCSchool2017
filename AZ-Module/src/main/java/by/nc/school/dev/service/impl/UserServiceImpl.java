package by.nc.school.dev.service.impl;

import by.nc.school.dev.beans.User;
import by.nc.school.dev.dao.DAOInterfacesEntities.UserDAO;
import by.nc.school.dev.exceptions.UserException;
import by.nc.school.dev.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Required
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean addUser(User user) throws UserException {
        return userDAO.addUser(user);
    }

    public List<User> getListUsers() throws UserException {
        return userDAO.getListUsers();
    }

    public User getUserById(int id) throws UserException {
        return userDAO.getUserById(id);
    }

    public User findUserByUsername(String username) throws UserException {
        return userDAO.findUserByUsername(username);
    }

    public void updateUser(User user) throws UserException {
        userDAO.updateUser(user);
    }

    public boolean doLogin(User user) {
        return userDAO.doLogin(user);
    }


}
