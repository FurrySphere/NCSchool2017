package by.nc.school.dev.example.servlet.persistence;

import by.nc.school.dev.example.servlet.model.User;

import java.util.List;

class UserDAOImpl implements UserDAO {

    protected InmemoryStorage storage;

    UserDAOImpl() {}

    @Override
    public List<User> getAllUsers() {
        return InmemoryStorage.getInstance().getUsers();
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

    public void setStorage(InmemoryStorage storage) {
        this.storage = storage;
    }

}
