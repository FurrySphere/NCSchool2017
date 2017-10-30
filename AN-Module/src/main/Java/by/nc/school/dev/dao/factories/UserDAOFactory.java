package by.nc.school.dev.dao.factories;

import by.nc.school.dev.dao.UserDAO;
import by.nc.school.dev.dao.implication.UserDAOImpl;

public class UserDAOFactory {
    public static UserDAOImpl getInstance()
    {
        return new UserDAOImpl();
    }
}
