package by.nc.school.dev.web.command.util;

import by.nc.school.dev.beans.User;
import by.nc.school.dev.exceptions.UserException;
import by.nc.school.dev.service.impl.UserServiceImpl;

public class DataChecker {
    public static boolean checkLoginExist(String login) throws UserException {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        User user = userServiceImpl.findUserByUsername(login);
        return user != null;
    }
}
