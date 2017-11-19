package by.nc.school.dev.service.user.implication;

import by.nc.school.dev.dao.UserDAO;
import by.nc.school.dev.dao.factories.UserDAOFactory;
import by.nc.school.dev.model.user.User;
import by.nc.school.dev.service.user.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDAO userDAO;

    public void addUser(User user) {
        userDAO = UserDAOFactory.getInstance();
        userDAO.create(user);
    }

    public boolean login(String userName, String password) {
        userDAO = UserDAOFactory.getInstance();
        User user = userDAO.getByUsername(userName);
        if(user.getPassword().equals(password))
        {
            return true;
        }
        return false;
    }

    public void geleteUser(String userName) {
        userDAO = UserDAOFactory.getInstance();
        userDAO.delete(userName);
    }

    public void getByUserName(String userName){
        userDAO = UserDAOFactory.getInstance();
    }

    public void update(User user) {

    }
}
