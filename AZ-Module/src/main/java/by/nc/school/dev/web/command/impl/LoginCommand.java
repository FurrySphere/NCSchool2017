package by.nc.school.dev.web.command.impl;

import by.nc.school.dev.beans.Student;
import by.nc.school.dev.beans.User;
import by.nc.school.dev.beans.enums.Role;
import by.nc.school.dev.exceptions.UserException;
import by.nc.school.dev.service.DataValidator;
import by.nc.school.dev.service.ServiceFactory;
import by.nc.school.dev.service.interfaces.ProfessorService;
import by.nc.school.dev.service.interfaces.StudentService;
import by.nc.school.dev.service.interfaces.UserService;
import by.nc.school.dev.web.command.Command;
import by.nc.school.dev.web.command.util.PageConst;
import by.nc.school.dev.web.command.util.ParamConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginCommand implements Command {
    private UserService userService;
    private StudentService studentService;
    private ProfessorService professorService;

    private LoginCommand() {
        ServiceFactory serviceFactory = new ServiceFactory();
        userService = serviceFactory.getUserServiceInstance();
        studentService = serviceFactory.getStudentServiceInstance();
        professorService = serviceFactory.getProfessorServiceInstance();
    }

    private static class LoginCommandHolder {
        private final static LoginCommand instance = new LoginCommand();
    }

    public static LoginCommand getInstance() {
        return LoginCommandHolder.instance;
    }

    public String execute(HttpServletRequest request) throws UserException {
        HttpSession session = request.getSession();
        /*if (session.getAttribute(ParamConst.USER_ROLE) != null) {

            List<Student> students = StudentService.getAll();
            request.setAttribute("students", students);
            if (session.getAttribute(ParamConst.USER_ROLE).equals(Role.ADMIN)) {
                List<String> subjects = StudentService.getAllSubjects();
                request.setAttribute("subjects", subjects);
                return PageConst.WELCOME_ADMIN_PAGE;
            } else {
                return PageConst.WELCOME_USER_PAGE;
            }
        }
        String page;
        String login = request.getParameter(ParamConst.USER_LOGIN);
        String password = request.getParameter(ParamConst.USER_PASSWORD);
        User user = userService.findUserByUsername(login);
        if (user == null) {
            request.setAttribute("errorLogin", true);
            return PageConst.LOGIN_PAGE;
        }
        if (DataValidator.checkPass(password, user.getPassword())) {
            session.setAttribute(ParamConst.USER_ID, user.getId());
            session.setAttribute(ParamConst.USER_LOGIN, user.getUsername());
            session.setAttribute(ParamConst.USER_PASSWORD, user.getPassword());
            session.setAttribute(ParamConst.USER_ROLE, user.getRole().toString().toUpperCase());
            session.setAttribute(ParamConst.USER_SURNAME, user.getSurname());
            session.setAttribute(ParamConst.USER_NAME, user.getName());
            session.setAttribute(ParamConst.USER_EMAIL, user.getEmail());
            session.setAttribute(ParamConst.USER_TELEPHONE_NUMBER, user.getTelephoneNumber());

            List<Student> students = StudentService.getAll();
            request.setAttribute("students", students);
            if (user.getRole().equals(Role.ADMIN)) {
                List<String> subjects = StudentService.getAllSubjects();
                request.setAttribute("subjects", subjects);
                page = PageConst.WELCOME_ADMIN_PAGE;
            } else {
                page = PageConst.WELCOME_USER_PAGE;
            }
        } else {
            request.setAttribute("errorPassword", true);
            page = PageConst.LOGIN_PAGE;
        }*/
        //return page;
        return PageConst.WELCOME_ADMIN_PAGE;
    }
}