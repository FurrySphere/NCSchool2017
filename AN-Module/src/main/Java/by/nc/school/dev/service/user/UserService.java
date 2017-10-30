package by.nc.school.dev.service.user;

import by.nc.school.dev.model.user.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    boolean login(String userName, String password);
    void geleteUser(String userName);
}