package by.nc.school.dev.controller.actions.userActions;

import by.nc.school.dev.entities.User;
import by.nc.school.dev.controller.abstarctFactory.ActionInterface;
import by.nc.school.dev.controller.controllers.LoginController;

public class DoLogin implements ActionInterface {
    public String execute() throws Exception {
        LoginController controller = new LoginController();
        User user = new User(1, "tix546", "456987");
        //User user = new User();
        //user.setUsername(userNew.getParameter("username"));
       // user.setPassword(request.getParameter("password"));
        boolean isValid = controller.checkUser(user);
        System.out.println(user);
        if (isValid) {
            return "User logs successfully!";
        } else {
            return "Username or password isn't valid.";
        }
    }


}

