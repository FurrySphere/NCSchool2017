package by.nc.school.dev.web.command;

import by.nc.school.dev.web.command.impl.*;

public enum CommandType {
    LOGIN(LoginCommand.getInstance()),
    LOGOUT(LogoutCommand.getInstance()),
    REGISTER(RegisterCommand.getInstance()),
    NULL(NullCommand.getInstance()),
    USERS(ShowUserListCommand.getInstance());

    //UPDATE_USER(EditUserCommand.getInstance()),

    //ADD_STUDENT(AddStudentCommand.getInstance()),
    //UPDATE_STUDENT(EditStudentCommand.getInstance()),
    //REDIRECT_TO_EDIT_STUDENT(RedirectToEditStudentCommand.getInstance()),
    //REDIRECT_TO_EDIT_USER(RedirectToEditUserCommand.getInstance()),
    //SHOW_STUDENT_LIST(ShowStudentListCommand.getInstance()),
    //GET_MARK_LIST(GetSubjectListCommand.getInstance());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
