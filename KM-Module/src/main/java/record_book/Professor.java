package record_book;

import java.util.Date;

public class Professor extends Person {
    private boolean isSteelWorking;
    private ProfessorDegree degree;

    public Professor(String fullName, Date birthday, String address, Sex sex, boolean isSteelWorking, ProfessorDegree degree) {
        super(fullName, birthday, address, sex);
        this.isSteelWorking = isSteelWorking;
        this.degree = degree;
    }

    public boolean isSteelWorking() {
        return isSteelWorking;
    }

    public void setSteelWorking(boolean steelWorking) {
        isSteelWorking = steelWorking;
    }

    public ProfessorDegree getDegree() {
        return degree;
    }

    public void setDegree(ProfessorDegree degree) {
        this.degree = degree;
    }
}
