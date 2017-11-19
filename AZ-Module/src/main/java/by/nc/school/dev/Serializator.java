package by.nc.school.dev;

import by.nc.school.dev.beans.User;
import by.nc.school.dev.exceptions.UserException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializator {
    public boolean serialization(List<User> userList, String fileName) throws UserException {
        boolean flag = false;
        File file = new File(fileName);
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {
                objectOutputStream = new ObjectOutputStream(fos);
                for (User user : userList) {
                    objectOutputStream.writeLong(user.getId());
                    objectOutputStream.writeUTF(user.getUsername());
                    objectOutputStream.writeUTF(user.getPassword());
                    objectOutputStream.writeUTF(String.valueOf(user.getRole()));
                    objectOutputStream.writeUTF(user.getSurname());
                    objectOutputStream.writeUTF(user.getName());
                    objectOutputStream.writeUTF(user.getEmail());
                    objectOutputStream.writeUTF(user.getTelephoneNumber());

                }
                flag = true;
            }
        } catch (FileNotFoundException e) {
            throw new UserException("The file can't be create!", e);
        } catch (NotSerializableException e) {
            throw new UserException("Class doesn't support serialization!", e);
        } catch (IOException e) {
            throw new UserException(e);
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                throw new UserException("Error in closing of stream!");
            }
        }
        return flag;
    }

    public List<User> deserialization(String fileName) throws InvalidObjectException, UserException {
        List<User> usersList = new ArrayList<User>();

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(fileName)));
            while (objectInputStream.available() > 0) {
                User user = new User();
                user.setId(objectInputStream.readLong());
                user.setUsername(objectInputStream.readUTF());
                user.setPassword(objectInputStream.readUTF());
                //user.setRole(objectInputStream.readUTF());
                user.setSurname(objectInputStream.readUTF());
                user.setName(objectInputStream.readUTF());
                user.setEmail(objectInputStream.readUTF());
                user.setTelephoneNumber(objectInputStream.readUTF());
                usersList.add(user);
            }
            objectInputStream.close();
            return usersList;
        } catch (FileNotFoundException e) {
            throw new UserException("The file for deserialization doesn't exist!", e);
        } catch (InvalidClassException e) {
            throw new UserException("Mismatched versions of classes!", e);
        } catch (IOException e) {
            throw new UserException("General I/O error!", e);
        }
    }
}