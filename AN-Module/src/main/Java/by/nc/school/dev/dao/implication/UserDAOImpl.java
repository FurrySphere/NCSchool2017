package by.nc.school.dev.dao.implication;


import by.nc.school.dev.dao.UserDAO;
import by.nc.school.dev.model.user.User;

import java.io.*;
import java.util.*;

public class UserDAOImpl implements UserDAO {

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    List<User> users;
    File file = new File("Students.dat");;

    public User get(int id) {
        return null;
    }

    public void create(User user){
        users = new ArrayList<User>();
        read(file, users);
        users.add(user);
        write(file, users);
    }

    public void update(User user) {

    }

    public void delete(String userName) {
        users = new ArrayList<User>();
        read(file, users);
        for(User user: users)
        {
            if(user.getUsername().equals(userName))
            {

            }
        }

    }

    public List<User> getAll() {
        users = new ArrayList<User>();
        read(file, users);
        return users;
    }

    public User getByUsername(String username) {
        users = new ArrayList<User>();
        read(file, users);
        for(User user: users)
        {
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    static void write(File data, List<User> list) {
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(data)));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        }
        catch (IOException ex)
        {}
    }

    static void read(File data, List<User> list){
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(data)));
            list = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
        }
        catch (IOException ex)
        {}
        catch (Exception e)
        {}
    }
}
