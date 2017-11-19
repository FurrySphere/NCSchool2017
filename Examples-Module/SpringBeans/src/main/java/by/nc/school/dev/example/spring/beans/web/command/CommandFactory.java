package by.nc.school.dev.example.spring.beans.web.command;

import org.springframework.beans.factory.annotation.Required;

import java.util.Map;

public class CommandFactory {

    protected Map<String, Command> commands;

    public Command getInstance(String command) {
        return commands.get(command);
    }

    @Required
    public void setCommands(Map<String, Command> commands) {
        this.commands = commands;
    }

}
