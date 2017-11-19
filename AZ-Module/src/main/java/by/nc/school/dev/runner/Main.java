package by.nc.school.dev.runner;

import by.nc.school.dev.Serializator;
import by.nc.school.dev.beans.User;
import by.nc.school.dev.exceptions.UserException;

import java.io.InvalidObjectException;
import java.util.List;

public class Main {
    public static void main( String[] args ) throws UserException {
        /*ReadWriteFiles readFile = new ReadWriteFiles();
        List<User> usersList = readFile.readFileUser("files\\users.txt");
        for (User user : usersList) {
            System.out.println(user);
        }

        String file = "files\\inputSerialize.data";
        Serializator serializator = new Serializator();
        boolean b = serializator.serialization(usersList, file);
        ////////////////////////////////////////////
        List<User> result;
        try {
            result = serializator.deserialization(file);
        } catch (InvalidObjectException e) {
            throw new UserException(e);
        }
        ReadWriteFiles writeFile = new ReadWriteFiles();
        writeFile.writeDeserializeFile(result, "files\\outputDeserialize.txt");*/
    }
}
