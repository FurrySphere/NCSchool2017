package record_book;

import java.util.List;
import java.util.Map;

public class Journal {
    private Map<String, List<Student>> listOfStudentsByGroup;
    private List<Course> courses;
    private Map<Student, List<Integer>> marksOfStudents;
    private int year;
    private int semester;
    private AcademicDirection direction;

    public Journal(Map<String, List<Student>> listOfStudentsByGroup,
                   List<Course> courses,
                   Map<Student, List<Integer>> marksOfStudents,
                   int year,
                   int semester,
                   AcademicDirection direction) {
        this.listOfStudentsByGroup = listOfStudentsByGroup;
        this.courses = courses;
        this.marksOfStudents = marksOfStudents;
        this.year = year;
        this.semester = semester;
        this.direction = direction;
    }

    public Map<Student, List<Integer>> getMarksOfStudents() {
        return marksOfStudents;
    }

    public void setStudentsMark(Student student, Course course, int mark){
        List<Integer> marksOfStudent = marksOfStudents.get(student);
        int poz = courses.indexOf(course);
        if(marksOfStudent!=null && poz!=-1){
            marksOfStudent.set(poz, mark);
        }
    }

    public Map<String, List<Student>> getListOfStudentsByGroup() {
        return listOfStudentsByGroup;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getYear() {
        return year;
    }

    public int getSemester() {
        return semester;
    }

    public AcademicDirection getDirection() {
        return direction;
    }

    public void addStudent(String group, Student student){
        List<Student> groupList = listOfStudentsByGroup.get(group);
        if(groupList!=null) {
            listOfStudentsByGroup.get(group).add(student);
        }
    }
}
