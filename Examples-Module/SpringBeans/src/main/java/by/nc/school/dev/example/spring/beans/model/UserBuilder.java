package by.nc.school.dev.example.spring.beans.model;

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

}
