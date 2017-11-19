package by.nc.school.dev.example.servlet.web.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    String execute(HttpServletRequest request);

}
