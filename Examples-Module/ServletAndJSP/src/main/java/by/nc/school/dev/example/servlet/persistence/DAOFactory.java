package by.nc.school.dev.example.servlet.persistence;

public class DAOFactory {

    protected static UserDAO userDaoInstance;

    public UserDAO getUserDaoInstance() {
        synchronized (UserDAO.class) {
            if (userDaoInstance == null) {
                UserDAOImpl userDao = new UserDAOImpl();
                userDao.setStorage(InmemoryStorage.getInstance());
                userDaoInstance = userDao;
            }
        }
        return userDaoInstance;
    }

}
