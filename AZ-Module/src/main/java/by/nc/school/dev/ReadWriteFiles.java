package by.nc.school.dev;

import by.nc.school.dev.beans.User;
import by.nc.school.dev.dao.DAOFactories.DAOFactory;
import by.nc.school.dev.exceptions.UserException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFiles {
    public List<User> readFileUser(String fileName) throws UserException {
        List<User> usersList = new ArrayList<User>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            throw new UserException(e);
        }
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] userArray = line.split(" ");
            User user = DAOFactory.getDAOFactory(3).getUserDAO().addUser(userArray);
            if (!DAOFactory.getDAOFactory(3).getUserDAO().findUser(user, usersList)) {
                usersList.add(user);
            }
        }
        return usersList;
    }

    public void writeDeserializeFile(List<User> userList, String fileName) throws UserException {
        try {
            Writer writer = new FileWriter(fileName);
            for (User user : userList) {
                writer.write(user.toString());
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
            } catch (IOException e) {
                throw new UserException(e);
            }
        }
}