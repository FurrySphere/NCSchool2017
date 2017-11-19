package by.nc.school.dev.web.command.factory;

import by.nc.school.dev.web.command.Command;
import by.nc.school.dev.web.command.CommandType;
import by.nc.school.dev.web.command.impl.NullCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class CommandFactory {
    private static AtomicBoolean instanceCreated = new AtomicBoolean();
    private static CommandFactory instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new CommandFactory();
                    instanceCreated = new AtomicBoolean(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Command defineCommand(HttpServletRequest request) {
        String requestCommand = request.getParameter("command");
        Command command = NullCommand.getInstance();
        if (requestCommand != null && !requestCommand.equals("")) {
            System.out.println(requestCommand);
            CommandType commandType = CommandType.valueOf(requestCommand.toUpperCase());
            command = commandType.getCommand();
        }
        return command;
    }
}
