package by.nc.school.dev.example.servlet.web.provider;

import by.nc.school.dev.example.servlet.persistence.UserDAO;

import javax.servlet.http.HttpServletRequest;

public class HomeModelProvider implements ModelProvider {

    protected UserDAO userDAO;

    HomeModelProvider() {}

    @Override
    public void fillRequest(HttpServletRequest request) {
        request.setAttribute("users", userDAO.getAllUsers());
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
