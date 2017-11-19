package by.nc.school.dev.example.servlet.persistence;

import by.nc.school.dev.example.servlet.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUser(String login);

    void addUser(User user);

}
