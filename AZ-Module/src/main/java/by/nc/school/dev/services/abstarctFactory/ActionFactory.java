package by.nc.school.dev.controller.abstarctFactory;

import by.nc.school.dev.controller.actions.departmentActions.CreateAcademicStatisticsPerformance;
import by.nc.school.dev.controller.actions.departmentActions.CreateAttendanceStatistics;
import by.nc.school.dev.controller.actions.departmentActions.ShowTableMarks;
import by.nc.school.dev.controller.actions.professorActions.AddProfessor;
import by.nc.school.dev.controller.actions.professorActions.EditProfessor;
import by.nc.school.dev.controller.actions.professorActions.ShowProfessorProfile;
import by.nc.school.dev.controller.actions.studentActions.*;
import by.nc.school.dev.controller.actions.groupActions.EditGroup;
import by.nc.school.dev.controller.actions.groupActions.AddGroup;
import by.nc.school.dev.controller.actions.subjectActions.GetFinalMarkSubject;
import by.nc.school.dev.controller.actions.userActions.AddUser;
import by.nc.school.dev.controller.actions.userActions.DoLogin;
import by.nc.school.dev.controller.actions.userActions.DoesUserExist;
import java.util.Map;

public class ActionFactory {
    private Map<String, ActionInterface> actions;

    public ActionFactory() {
        actions.put("doLogin", new DoLogin());
        actions.put("doesUserExist", new DoesUserExist());
        actions.put("addUser", new AddUser());

        actions.put("addGroup", new AddGroup());
        actions.put("editGroup", new EditGroup());

        actions.put("addStudent", new AddStudent());
        actions.put("editStudent", new EditStudent());
        actions.put("showStudentProfile", new ShowStudentProfile());
        actions.put("getCoefficientScholarship", new GetCoefficientScholarship());
        actions.put("getListLearningSubjects", new GetListLearningSubjects());

        actions.put("addProfessor", new AddProfessor());
        actions.put("editProfessor", new EditProfessor());
        actions.put("showProfessorProfile", new ShowProfessorProfile());

        actions.put("getFinalMarkSubject", new GetFinalMarkSubject());

        actions.put("createAttendanceStatistics", new CreateAttendanceStatistics());
        actions.put("createAcademicStatisticsPerformance", new CreateAcademicStatisticsPerformance());
        actions.put("showTableMarks", new ShowTableMarks());
    }
}
