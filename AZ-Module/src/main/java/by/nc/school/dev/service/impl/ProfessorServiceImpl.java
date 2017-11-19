package by.nc.school.dev.service.impl;

import by.nc.school.dev.dao.DAOInterfacesEntities.ProfessorDAO;
import by.nc.school.dev.service.interfaces.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorDAO professorDAO;

    public void setProfessorDAO(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }
}
