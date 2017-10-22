package by.nc.school.dev.dao.DAOInterfacesEntities;

import by.nc.school.dev.beans.User;

import java.util.List;

public interface UserDAO {
    public User addUser(String[] userArray);
    //public boolean deleteUser();
    public boolean findUser(User user, List<User> usersList);
    public List<User> editUser(User editingUser, User oldUser, List<User> usersList);
    public boolean doLogin(User user);
}
