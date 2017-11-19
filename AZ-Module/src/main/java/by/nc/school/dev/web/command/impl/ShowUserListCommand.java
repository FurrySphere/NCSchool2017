package by.nc.school.dev.web.command.impl;

import by.nc.school.dev.dao.DAOInterfacesEntities.UserDAO;
import by.nc.school.dev.exceptions.UserException;
import by.nc.school.dev.web.command.Command;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.http.HttpServletRequest;

public class ShowUserListCommand implements Command {
    protected UserDAO userDAO;

    public ShowUserListCommand() {
    }

    private static class ShowUserListCommandHolder {
        private final static ShowUserListCommand instance = new ShowUserListCommand();
    }

    public String execute(HttpServletRequest request) throws UserException {
        return null;
    }

    public static ShowUserListCommand getInstance() {
        return ShowUserListCommandHolder.instance;
    }

    @Required
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
