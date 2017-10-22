package by.nc.school.dev.dao.DAOInterfacesEntities;

import by.nc.school.dev.beans.User;

public interface UserDAO {
    public int addUser();
    //public boolean deleteUser();
    public User findUser();
    public boolean editUser();
    public boolean doLogin();
}
