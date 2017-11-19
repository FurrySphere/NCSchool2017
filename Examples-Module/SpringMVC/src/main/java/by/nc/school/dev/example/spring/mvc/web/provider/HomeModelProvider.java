package by.nc.school.dev.example.spring.mvc.web.provider;

import by.nc.school.dev.example.spring.mvc.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

public class HomeModelProvider implements ModelProvider {

    protected UserDAO userDAO;

    private HomeModelProvider() {}

    @Override
    public void fillModel(Model model) {
        model.addAttribute("users", userDAO.getAllUsers());
    }

    @Required
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
