package by.nc.school.dev.dao;

import by.nc.school.dev.model.user.User;

import java.io.IOException;
import java.util.List;

public interface UserDAO {

    User get(int id);

    User getByUsername(String username);

    void create(User user);

    void update(User user);

    void delete(String userName);

    List<User> getAll();

}
