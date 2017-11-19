package by.nc.school.dev.example.spring.mvc.persistence;

import by.nc.school.dev.example.spring.mvc.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUser(String login);

    void addUser(User user);

}
