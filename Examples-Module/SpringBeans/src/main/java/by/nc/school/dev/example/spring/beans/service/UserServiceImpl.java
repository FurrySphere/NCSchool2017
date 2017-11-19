package by.nc.school.dev.example.spring.beans.service;

import by.nc.school.dev.example.spring.beans.model.User;
import by.nc.school.dev.example.spring.beans.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

class UserServiceImpl implements UserService {

    protected UserDAO userDAO;

    private UserServiceImpl() {}

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

    @Required
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
