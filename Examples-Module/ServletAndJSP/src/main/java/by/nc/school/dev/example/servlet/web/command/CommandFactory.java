package by.nc.school.dev.example.servlet.web.command;

import by.nc.school.dev.example.servlet.persistence.DAOFactory;
import by.nc.school.dev.example.servlet.service.ServiceFactory;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    protected static Map<String, Command> commands;

    public Command getInstance(String command) {
        synchronized (Command.class) {
            if (commands == null) {

                commands = new HashMap<>();

                // login
                LoginCommand loginCommand = new LoginCommand();
                loginCommand.setUserService(new ServiceFactory().getUserServiceInstance());
                commands.put(CommandNames.LOGIN, loginCommand);

                // new user
                NewUserCommand newUserCommand = new NewUserCommand();
                newUserCommand.setUserDAO(new DAOFactory().getUserDaoInstance());
                commands.put(CommandNames.NEW_USER, newUserCommand);

            }
        }
        return commands.get(command);
    }

}
