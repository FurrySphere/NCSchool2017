package record_book;

import java.util.Date;

public class Student extends Person {
    private StudentStatus status;

    public Student(String fullName, Date birthday, String address, Sex sex, StudentStatus status) {
        super(fullName, birthday, address, sex);
        this.status = status;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }
}
