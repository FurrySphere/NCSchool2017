package by.nc.school.dev.example.spring.mvc.persistence;

import by.nc.school.dev.example.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

class UserDAOImpl implements UserDAO {

    protected InmemoryStorage storage;

    private UserDAOImpl() {}

    @Override
    public List<User> getAllUsers() {
        return storage.getUsers();
    }

    @Override
    public User getUser(String login) {
        if (login == null) {
            return null;
        }
        for (User user : storage.getUsers()) {
            if (login.equals(user.getLogin())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        storage.getUsers().add(user);
        storage.save();
    }

    @Required
    public void setStorage(InmemoryStorage storage) {
        this.storage = storage;
    }

}
