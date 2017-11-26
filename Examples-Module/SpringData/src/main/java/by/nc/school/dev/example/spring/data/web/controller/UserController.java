package by.nc.school.dev.example.spring.data.web.controller;

import by.nc.school.dev.example.spring.data.model.Country;
import by.nc.school.dev.example.spring.data.service.CountryService;
import by.nc.school.dev.example.spring.data.service.UserService;
import by.nc.school.dev.example.spring.data.web.Pages;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping(Pages.USER.PATH_ABSOLUTE)
public class UserController {

    protected UserService userService;
    protected CountryService countryService;

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

    @Transactional
    @RequestMapping(method = RequestMethod.POST, path = Pages.USER.NEW_USER.PATH)
    public String execute(@RequestParam("username") String userName
                         ,@RequestParam("password") String password
                         ,@RequestParam("countries") String countries) {
        Set<Country> countrySet = null;
        if (countries != null && !countries.trim().equals("")) {
            List<String> countryNames = splitByComma(countries);
            if (!countryNames.isEmpty()) {
                countrySet = new HashSet<>();
            }
            for (String countryName : countryNames) {
                Country country = countryService.getOrCreateCountryByName(countryName);
                countrySet.add(country);
            }
        }
        userService.createUser(userName, password, countrySet);
        return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
    }

    public List<String> splitByComma(String source) {
        String[] strArr = source.split(",");
        return Arrays.asList(strArr);
    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Required
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }
}
