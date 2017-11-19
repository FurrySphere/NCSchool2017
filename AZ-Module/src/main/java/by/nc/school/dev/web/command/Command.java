package by.nc.school.dev.web.command;

import by.nc.school.dev.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws UserException;
}
