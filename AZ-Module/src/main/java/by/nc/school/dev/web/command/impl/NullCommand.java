package by.nc.school.dev.web.command.impl;

import by.nc.school.dev.web.command.Command;
import by.nc.school.dev.web.command.util.PageConst;

import javax.servlet.http.HttpServletRequest;

public class NullCommand implements Command {
    private NullCommand() {
    }

    private static class NullCommandHolder {
        private final static NullCommand instance = new NullCommand();
    }

    public static NullCommand getInstance() {
        return NullCommandHolder.instance;
    }

    public String execute(HttpServletRequest request) {
        return PageConst.INDEX;
    }
}
