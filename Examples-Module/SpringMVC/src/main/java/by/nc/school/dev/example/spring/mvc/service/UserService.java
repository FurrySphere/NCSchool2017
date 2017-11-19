package by.nc.school.dev.example.spring.mvc.service;

public interface UserService {

    boolean checkAuthorization(String login, String password);

    void createUser(String login, String password);

}
