package by.nc.school.dev.example.spring.beans.web.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    String execute(HttpServletRequest request);

}
