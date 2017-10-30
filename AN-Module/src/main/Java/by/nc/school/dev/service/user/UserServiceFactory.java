package by.nc.school.dev.service.user;

import by.nc.school.dev.service.user.UserService;
import by.nc.school.dev.service.user.implication.UserServiceImpl;

public class UserServiceFactory {
    public static UserServiceImpl getInstance()
    {
        return new UserServiceImpl();
    }
}
