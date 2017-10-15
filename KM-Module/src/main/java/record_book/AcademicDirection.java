package record_book;

public class AcademicDirection {
    private String university;
    private String faculty;
    private String speciality;

    public AcademicDirection(String university, String faculty, String speciality) {
        this.university = university;
        this.faculty = faculty;
        this.speciality = speciality;
    }

    public String getUniversity() {
        return university;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpeciality() {
        return speciality;
    }
}
