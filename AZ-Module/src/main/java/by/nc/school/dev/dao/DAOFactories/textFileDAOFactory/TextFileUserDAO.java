package by.nc.school.dev.dao.DAOFactories.textFileDAOFactory;

import by.nc.school.dev.beans.User;
import by.nc.school.dev.dao.DAOInterfacesEntities.UserDAO;

import java.util.List;

public class TextFileUserDAO implements UserDAO {
    public User addUser(String[] userArray) {
        User user = new User();
        user.setId(Long.parseLong(userArray[0]));
        user.setUsername(userArray[1]);
        user.setPassword(userArray[2]);
        user.setRole(userArray[3]);
        user.setSurname(userArray[4]);
        user.setName(userArray[5]);
        user.setEmail(userArray[6]);
        user.setTelephoneNumber(userArray[7]);
        return user;
    }

    public boolean findUser(User user, List<User> usersList) {
        return usersList.contains(user);
    }

    public List<User> editUser(User editingUser, User oldUser, List<User> usersList) {
        if (findUser(oldUser, usersList)) {
            for (int i = 0; i < usersList.size(); i++) {
                if (oldUser.equals(usersList.get(i))) {
                    usersList.set(i, editingUser);
                }
            }
        }
        return usersList;
    }

    public boolean doLogin(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        boolean isValid = checkUser(user);
        System.out.println(user);
        if (isValid) {
            return true;
        } else {
            System.err.println("error! Username or password is invalid!");
        }
        return false;
    }

    private boolean checkUser(User user) {
        return false;
    }
}
