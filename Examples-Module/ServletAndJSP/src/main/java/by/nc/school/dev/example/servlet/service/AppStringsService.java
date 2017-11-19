package by.nc.school.dev.example.servlet.service;

public interface AppStringsService {

    String KEY_ERROR_ON_LOAD_APP_CONFIG = "exception.load_appconfig";
    String KEY_ERROR_ON_SAVE_STORAGE = "exception.save_storage";

    // login page
    String KEY_WEB_LOGIN_TITLE = "web.login.title";
    String KEY_WEB_LOGIN_USER = "web.login.user";
    String KEY_WEB_LOGIN_PASSWORD = "web.login.password";
    String KEY_WEB_LOGIN_SUBMIT = "web.login.submit";

    // home page
    String KEY_WEB_HOME_TITLE = "web.home.title";
    String KEY_WEB_HOME_NEWUSER_TITLE = "web.home.newuser.title";
    String KEY_WEB_HOME_NEWUSER_SUBMIT = "web.home.newuser.submit";

    String getString(String key);

    String getString(String key, Object... substitution);

}
