package record_book;

import record_book.SubjectType;

public class Subject {
    private String name;
    private SubjectType subjectType;

    public Subject(String name, SubjectType subjectType) {
        this.name = name;
        this.subjectType = subjectType;
    }

    public String getName() {
        return name;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }
}
