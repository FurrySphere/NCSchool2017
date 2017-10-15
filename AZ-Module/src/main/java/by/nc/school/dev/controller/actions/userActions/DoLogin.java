package by.nc.school.dev.controller.actions;

import by.nc.school.dev.beans.User;
import by.nc.school.dev.beans.enums.Role;
import by.nc.school.dev.controller.abstarctFactory.ActionInterface;
import by.nc.school.dev.controller.controllers.LoginController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoLogin implements ActionInterface {
    public String execute() throws Exception {
        User user = new User(1, "Tixonova", "Darya", new Role(0));
        LoginController controller = new LoginController();
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setRole();
                boolean isValid = controller.checkUser(user);
                System.out.println(user);
                if (isValid) {
                    return "User log successfully!";
                } else {
                    request.setAttribute("error", "Пользователь или пароль введены неверно!");
                    return "Username or password isn't valid.";
                }
    }


}

