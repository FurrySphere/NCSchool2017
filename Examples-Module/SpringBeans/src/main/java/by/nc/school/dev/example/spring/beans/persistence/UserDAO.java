package by.nc.school.dev.example.spring.beans.persistence;

import by.nc.school.dev.example.spring.beans.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUser(String login);

    void addUser(User user);

}
