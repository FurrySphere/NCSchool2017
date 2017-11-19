package by.nc.school.dev.web.command.impl;

import by.nc.school.dev.beans.User;
import by.nc.school.dev.beans.enums.Role;
import by.nc.school.dev.dao.DAOInterfacesEntities.UserDAO;
import by.nc.school.dev.exceptions.UserException;
import by.nc.school.dev.service.DataValidator;
import by.nc.school.dev.web.command.Command;
import by.nc.school.dev.web.command.util.DataChecker;
import by.nc.school.dev.web.command.util.PageConst;
import by.nc.school.dev.web.command.util.ParamConst;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    protected UserDAO userDAO;

    private RegisterCommand() {
    }

    private static class RegisterCommandHolder {
        private final static RegisterCommand instance = new RegisterCommand();
    }

    public static RegisterCommand getInstance() {
        return RegisterCommandHolder.instance;
    }

    public String execute(HttpServletRequest request) throws UserException {
        String page = PageConst.REGISTER_PAGE;
        String login = request.getParameter(ParamConst.USER_LOGIN);
        String password = request.getParameter(ParamConst.USER_PASSWORD);
        Role role = Role.valueOf(request.getParameter(ParamConst.USER_ROLE));
        String passwordRepeat = request.getParameter(ParamConst.USER_PASSWORD_REPEAT);
        String surname = request.getParameter(ParamConst.USER_SURNAME);
        String name = request.getParameter(ParamConst.USER_NAME);
        String email = request.getParameter(ParamConst.USER_EMAIL);
        String telephoneNumber = request.getParameter(ParamConst.USER_TELEPHONE_NUMBER);

        if (login == null || name == null || surname == null || email == null
                || telephoneNumber == null) {
            request.setAttribute("emptyFields", true);
            return page;
        }
        if (password == null || !password.equals(passwordRepeat)) {
            request.setAttribute("passwordError", true);
            return page;
        }
        if (!DataValidator.validateRegisterData(login, password)) {
            request.setAttribute("regexError", true);
            return page;
        }
        if (DataChecker.checkLoginExist(login)) {
            request.setAttribute("loginExists", true);
            return page;
        }
        User user = new User(login, password, role, surname, name, email, telephoneNumber);
        user.toString();
        if (userDAO.addUser(user)) {
            request.setAttribute("successAdd", true);
        } else {
            request.setAttribute("successAdd", false);
        }
        //userDAO.addUser(new User(login, password, role, surname, name, email, telephoneNumber));
        //request.setAttribute(ParamConst.USER_ID, user.getId());
        //request.setAttribute(ParamConst.USER_LOGIN, user.getUsername());
        //request.setAttribute(ParamConst.USER_PASSWORD, user.getPassword());
        //request.setAttribute(ParamConst.USER_ROLE, user.getRole().toString().toUpperCase());
        //request.setAttribute(ParamConst.USER_SURNAME, user.getSurname());
        //request.setAttribute(ParamConst.USER_NAME, user.getName());
        //request.setAttribute(ParamConst.USER_EMAIL, user.getEmail());
        //request.setAttribute(ParamConst.USER_TELEPHONE_NUMBER, user.getTelephoneNumber());

        return page;
    }

    @Required
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}