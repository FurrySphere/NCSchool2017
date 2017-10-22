package by.nc.school.dev.runner;

import by.nc.school.dev.ReadWriteFiles;
import by.nc.school.dev.Serializator;
import by.nc.school.dev.beans.User;
import by.nc.school.dev.exceptions.UserException;

import java.io.InvalidObjectException;
import java.util.List;

public class Main {
    public static void main( String[] args ) throws UserException {
        //User user = new User(123456, "darya79", "1456987", "STUDENT", "Tihonova",
        //        "Darya", "darya45.tix@gmail.com", "123-45-59");
        ReadWriteFiles readFile = new ReadWriteFiles();
        List<User> usersList = readFile.readFileUser("files\\users.txt");
        for (User user : usersList) {
            System.out.println(user);
        }
        //System.out.println(user);
        String file = "files\\inputSerialize.data";
        Serializator serializator = new Serializator();
        boolean b = false;
        //for (int i = 0; i < usersList.size(); i++) {
            b = serializator.serialization(usersList, file);
        //}
        ////////////////////////////////////////////
        List<User> result;
        try {

            result = serializator.deserialization(file);
        } catch (InvalidObjectException e) {
            throw new UserException(e);
        }
        ReadWriteFiles writeFile = new ReadWriteFiles();
        writeFile.writeDeserializeFile(result, "files\\outputDeserialize.txt");
    }
}
