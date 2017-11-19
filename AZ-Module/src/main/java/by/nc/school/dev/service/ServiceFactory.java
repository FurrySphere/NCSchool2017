package by.nc.school.dev.service;

import by.nc.school.dev.beans.Professor;
import by.nc.school.dev.dao.DAOFactories.AbstractDAOFactory;
import by.nc.school.dev.service.impl.ProfessorServiceImpl;
import by.nc.school.dev.service.impl.StudentServiceImpl;
import by.nc.school.dev.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static UserServiceImpl userServiceImpl;
    private static ProfessorServiceImpl professorServiceImpl;
    private static StudentServiceImpl studentServiceImpl;

    public UserServiceImpl getUserServiceInstance() {
        synchronized (UserServiceImpl.class) {
            if (userServiceImpl == null) {
                UserServiceImpl userServiceImpl = new UserServiceImpl();
                userServiceImpl.setUserDAO(AbstractDAOFactory.getDAOFactory(1).getUserDAO());
                ServiceFactory.userServiceImpl = userServiceImpl;
            }
        }
        return userServiceImpl;
    }

    public StudentServiceImpl getStudentServiceInstance() {
        synchronized (StudentServiceImpl.class) {
            if (studentServiceImpl == null) {
                StudentServiceImpl studentService = new StudentServiceImpl();
                studentService.setStudentDAO(AbstractDAOFactory.getDAOFactory(1).getStudentDAO());
                ServiceFactory.studentServiceImpl = studentService;
            }
        }
        return studentServiceImpl;
    }

    public ProfessorServiceImpl getProfessorServiceInstance() {
        synchronized (ProfessorServiceImpl.class) {
            if (professorServiceImpl == null) {
                ProfessorServiceImpl professorServiceImpl = new ProfessorServiceImpl();
                professorServiceImpl.setProfessorDAO(AbstractDAOFactory.getDAOFactory(1).getProfessorDAO());
                ServiceFactory.professorServiceImpl = professorServiceImpl;
            }
        }
        return professorServiceImpl;
    }
}
