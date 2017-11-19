package by.nc.school.dev.web.controller;

import by.nc.school.dev.exceptions.UserException;
import by.nc.school.dev.web.command.Command;
import by.nc.school.dev.web.command.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    protected static CommandFactory commandFactory;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Command command = commandFactory.getInstance().defineCommand(request);
            String page = command.execute(request);
            response.sendRedirect(page);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public static void setCommandFactory(CommandFactory commandFactory) {
        Controller.commandFactory = commandFactory;
    }
}

