package by.nc.school.dev.service.user;

import by.nc.school.dev.service.user.implication.UserServiceImpl;

public class UserServiceFactory {

    public static UserService userDaoInstance;

    public static UserService getInstance()
    {
        if (userDaoInstance == null) {
            userDaoInstance = new UserServiceImpl();
        }
        return userDaoInstance;
    }
}
