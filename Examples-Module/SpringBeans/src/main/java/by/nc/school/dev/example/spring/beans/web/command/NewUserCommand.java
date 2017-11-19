package by.nc.school.dev.example.spring.beans.web.command;

import by.nc.school.dev.example.spring.beans.model.User;
import by.nc.school.dev.example.spring.beans.model.UserBuilder;
import by.nc.school.dev.example.spring.beans.persistence.UserDAO;
import by.nc.school.dev.example.spring.beans.web.Pages;
import org.springframework.beans.factory.annotation.Required;

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

    @Required
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
