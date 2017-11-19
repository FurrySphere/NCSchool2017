package by.nc.school.dev.example.servlet.persistence;

import by.nc.school.dev.example.servlet.model.User;
import by.nc.school.dev.example.servlet.model.UserBuilder;
import by.nc.school.dev.example.servlet.service.AppConfigService;
import by.nc.school.dev.example.servlet.service.AppStringsService;
import by.nc.school.dev.example.servlet.service.ServiceFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class InmemoryStorage implements Serializable {

    private static InmemoryStorage instance;

    transient protected AppConfigService appConfigService;
    transient protected AppStringsService appStringsService;

    private List<User> users = new ArrayList<>();

    private InmemoryStorage() {}

    public static InmemoryStorage getInstance() {
        synchronized (InmemoryStorage.class) {
            if (instance == null) {
                ServiceFactory serviceFactory = new ServiceFactory();
                instance = loadStorage();
                instance.setAppConfigService(serviceFactory.getAppConfigServiceInstance());
                instance.setAppStringsService(serviceFactory.getAppStringsServiceInstance());
            }
        }
        return instance;
    }

    private static InmemoryStorage loadStorage() {
        AppConfigService appConfigService = new ServiceFactory().getAppConfigServiceInstance();
        try (InputStream fileInputStream = new FileInputStream(
                            System.getProperty("catalina.base") + "/"
                            + appConfigService.getPropertyValue(AppConfigService.KEY_INMEMORY_STORAGE_FILE)
            )) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (InmemoryStorage) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            InmemoryStorage inmemoryStorage = new InmemoryStorage();
            inmemoryStorage.getUsers().add(
                    new UserBuilder().setLogin("admin").setPassword("admin").build()
            );
            return inmemoryStorage;
        }
    }

    public void save() {
        try (OutputStream fileOutputStream = new FileOutputStream(
                    System.getProperty("catalina.base") + "/"
                    + appConfigService.getPropertyValue(AppConfigService.KEY_INMEMORY_STORAGE_FILE)
            )) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(appStringsService.getString(AppStringsService.KEY_ERROR_ON_SAVE_STORAGE), e);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setAppConfigService(AppConfigService appConfigService) {
        this.appConfigService = appConfigService;
    }

    public void setAppStringsService(AppStringsService appStringsService) {
        this.appStringsService = appStringsService;
    }
}
