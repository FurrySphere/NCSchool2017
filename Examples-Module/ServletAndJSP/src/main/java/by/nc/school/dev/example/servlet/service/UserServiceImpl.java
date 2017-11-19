package by.nc.school.dev.example.servlet.service;

import by.nc.school.dev.example.servlet.model.User;
import by.nc.school.dev.example.servlet.persistence.UserDAO;

import java.util.List;

class UserServiceImpl implements UserService {

    protected UserDAO userDAO;

    @Override
    public boolean checkAuthorization(String login, String password) {
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
