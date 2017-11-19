package by.nc.school.dev.service.interfaces;

import by.nc.school.dev.beans.User;
import by.nc.school.dev.dao.DAOFactories.mySQLDAO.MySQLUserDAO;
import by.nc.school.dev.exceptions.UserException;

import java.util.List;

public interface UserService {
    public boolean addUser(User user) throws UserException;
    public List<User> getListUsers() throws UserException;
    public User getUserById(int id) throws UserException;
    public User findUserByUsername(String username) throws UserException;
    public void updateUser(User user) throws UserException;
    public boolean doLogin(User user);
}
