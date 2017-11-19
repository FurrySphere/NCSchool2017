package by.nc.school.dev.service.impl;

import by.nc.school.dev.dao.DAOInterfacesEntities.StudentDAO;
import by.nc.school.dev.service.interfaces.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
