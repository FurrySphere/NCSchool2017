package by.nc.school.dev.example.spring.data.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserBuilder {

    private User user = new User();

    public User build() {
        return user;
    }

    public UserBuilder setLogin(String login) {
        user.setLogin(login);
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder addCountry(Country country) {
        Set<Country> countries = user.getCountries();
        if (countries == null) {
            countries = new HashSet<>();
            user.setCountries(countries);
        }
        countries.add(country);
        return this;
    }

    public UserBuilder addCountries(Collection<Country> countries) {
        if (countries == null) {
            return this;
        }
        for (Country country : countries) {
            addCountry(country);
        }
        return this;
    }

}
