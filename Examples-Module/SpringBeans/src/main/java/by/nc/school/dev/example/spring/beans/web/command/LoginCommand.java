package by.nc.school.dev.example.spring.beans.web.command;

import by.nc.school.dev.example.spring.beans.service.UserService;
import by.nc.school.dev.example.spring.beans.web.Pages;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.http.HttpServletRequest;

class LoginCommand implements Command {

    protected UserService userService;

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

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
