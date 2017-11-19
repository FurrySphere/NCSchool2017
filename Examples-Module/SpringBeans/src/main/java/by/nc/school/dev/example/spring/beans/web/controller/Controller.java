package by.nc.school.dev.example.spring.beans.web.controller;

import by.nc.school.dev.example.spring.beans.web.command.Command;
import by.nc.school.dev.example.spring.beans.web.Pages;
import by.nc.school.dev.example.spring.beans.web.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Pages.CONTROLLER)
public class Controller extends HttpServlet {

    public static final String COMMAND_PARAM = "command";

    protected static CommandFactory commandFactory;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String commandName = req.getParameter(COMMAND_PARAM);
        Command command = commandFactory.getInstance(commandName);
        String view = command.execute(req);
        resp.sendRedirect(view);

    }

    public static void setCommandFactory(CommandFactory commandFactory) {
        Controller.commandFactory = commandFactory;
    }

}
