package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.Country;
import by.nc.school.dev.example.spring.data.model.User;

import java.util.Collection;

public interface UserService {

    boolean checkAuthorization(String login, String password);

    User createUser(String login, String password, Collection<Country> countries);

}
