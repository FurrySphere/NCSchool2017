package by.nc.school.dev.example.spring.mvc.web.controller;

import by.nc.school.dev.example.spring.mvc.service.UserService;
import by.nc.school.dev.example.spring.mvc.web.Pages;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(Pages.USER.PATH_ABSOLUTE)
public class UserController {

    protected UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = Pages.USER.LOGIN.PATH)
    public String login(HttpSession session
                       ,@RequestParam("username") String userName
                       ,@RequestParam("password") String password) {
        boolean isLoggedIn = userService.checkAuthorization(userName, password);
        session.setAttribute(SessionAttributes.IS_LOGGED_IN, isLoggedIn);
        return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.USER.LOGOUT.PATH)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:" + Pages.VIEWS.LOGIN.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.USER.NEW_USER.PATH)
    public String execute(@RequestParam("username") String userName
                         ,@RequestParam("password") String password) {
        userService.createUser(userName, password);
        return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
