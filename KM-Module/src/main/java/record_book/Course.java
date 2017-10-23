package record_book;

import java.util.List;

public class Course {
    private List<Professor> professors;
    /*
    maybe will be added later but I don't sure
    private Map<Integer, List<Professor>> practic;
     */
    private Subject subject;

    public Course(List<Professor> professors, Subject subject) {
        this.professors = professors;
        this.subject = subject;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public Subject getSubject() {
        return subject;
    }
}
