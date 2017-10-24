package by.nc.school.dev.example.servlet.web.controller;

import by.nc.school.dev.example.servlet.web.Pages;
import by.nc.school.dev.example.servlet.web.command.CommandFactory;
import by.nc.school.dev.example.servlet.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Pages.CONTROLLER)
public class Controller extends HttpServlet {

    public static final String COMMAND_PARAM = "command";

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
        Command command = new CommandFactory().getInstance(commandName);
        String view = command.execute(req);
        resp.sendRedirect(view);

    }

}
