package by.nc.school.dev.example.servlet.web.command;

import by.nc.school.dev.example.servlet.service.UserService;
import by.nc.school.dev.example.servlet.web.Pages;

import javax.servlet.http.HttpServletRequest;

class LoginCommand implements Command {

    UserService userService;

    LoginCommand() {}

    @Override
    public String execute(HttpServletRequest request) {
        boolean isLoggedIn = userService.checkAuthorization(
                 request.getParameter("username")
                ,request.getParameter("password")
        );
        request.getSession().setAttribute(SessionAttributes.IS_LOGGED_IN, isLoggedIn);
        return Pages.HOME_PAGE;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
