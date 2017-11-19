package by.nc.school.dev.dao.factories;

import by.nc.school.dev.dao.UserDAO;
import by.nc.school.dev.dao.implication.UserDAOImpl;

public class UserDAOFactory {

    public static UserDAO userDaoInstance;

    public static UserDAO getInstance()
    {
        if (userDaoInstance == null) {
            userDaoInstance = new UserDAOImpl();
        }
        return userDaoInstance;
    }
}
