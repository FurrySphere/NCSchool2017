package by.nc.school.dev.example.servlet.web.command;

import by.nc.school.dev.example.servlet.model.User;
import by.nc.school.dev.example.servlet.model.UserBuilder;
import by.nc.school.dev.example.servlet.persistence.UserDAO;
import by.nc.school.dev.example.servlet.web.Pages;

import javax.servlet.http.HttpServletRequest;

class NewUserCommand implements Command {

    protected UserDAO userDAO;

    NewUserCommand() {}

    @Override
    public String execute(HttpServletRequest request) {
        User newUser = new UserBuilder()
                .setLogin(request.getParameter("username"))
                .setPassword(request.getParameter("password"))
                .build();
        userDAO.addUser(newUser);
        return Pages.HOME_PAGE;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
