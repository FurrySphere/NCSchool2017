package by.nc.school.dev.example.spring.beans.web.provider;

import by.nc.school.dev.example.spring.beans.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.http.HttpServletRequest;

public class HomeModelProvider implements ModelProvider {

    protected UserDAO userDAO;

    private HomeModelProvider() {}

    @Override
    public void fillRequest(HttpServletRequest request) {
        request.setAttribute("users", userDAO.getAllUsers());
    }

    @Required
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
