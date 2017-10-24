package by.nc.school.dev.example.servlet.service;

import by.nc.school.dev.example.servlet.persistence.DAOFactory;

import java.io.IOException;

public class ServiceFactory {

    protected static AppConfigService appConfigServiceInstance;
    protected static AppStringsService appStringsServiceInstance;
    protected static UserService userService;

    public AppConfigService getAppConfigServiceInstance() {
        synchronized (AppConfigService.class) {
            if (appConfigServiceInstance == null) {
                try {
                    appConfigServiceInstance = new AppConfigServiceImpl();
                } catch (IOException e) {
                    AppStringsService appStringsService = getAppStringsServiceInstance();
                    throw new RuntimeException(appStringsService.getString(AppStringsService.KEY_ERROR_ON_LOAD_APP_CONFIG), e);
                }
            }
        }
        return appConfigServiceInstance;
    }

    public AppStringsService getAppStringsServiceInstance() {
        synchronized (AppStringsService.class) {
            if (appStringsServiceInstance == null) {
                appStringsServiceInstance = new AppStringsServiceImpl();
            }
        }
        return appStringsServiceInstance;
    }

    public UserService getUserServiceInstance() {
        synchronized (UserService.class) {
            if (userService == null) {
                UserServiceImpl userServiceImpl = new UserServiceImpl();
                userServiceImpl.setUserDAO(new DAOFactory().getUserDaoInstance());
                userService = userServiceImpl;
            }
        }
        return userService;
    }
}
