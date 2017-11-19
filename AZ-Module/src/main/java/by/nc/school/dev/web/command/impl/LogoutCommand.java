package by.nc.school.dev.web.command.impl;

import by.nc.school.dev.web.command.Command;
import by.nc.school.dev.web.command.util.PageConst;
import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    private LogoutCommand() {
    }

    private static class LogoutCommandHolder {
        private final static LogoutCommand instance = new LogoutCommand();
    }

    public static LogoutCommand getInstance() {
        return LogoutCommandHolder.instance;
    }

    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return PageConst.INDEX;
    }
}