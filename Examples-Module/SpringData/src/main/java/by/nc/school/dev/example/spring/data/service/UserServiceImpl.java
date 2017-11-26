package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.Country;
import by.nc.school.dev.example.spring.data.model.User;
import by.nc.school.dev.example.spring.data.model.UserBuilder;
import by.nc.school.dev.example.spring.data.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

class UserServiceImpl implements UserService {

    protected UserRepository userRepository;

    private UserServiceImpl() {}

    @Override
    public boolean checkAuthorization(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user == null && "admin".equals(login)) {
            user = createUser("admin", "admin", null);
        }
        return user != null && user.getPassword().equals(password);
    }

    @Transactional
    @Override
    public User createUser(String login, String password, Collection<Country> countries) {
        User newUser = new UserBuilder()
                .setLogin(login)
                .setPassword(password)
                .addCountries(countries)
                .build();
        userRepository.save(newUser);
        return newUser;
    }

    @Required
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
