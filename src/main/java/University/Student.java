package University;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Student extends PersonImpl {
    private List<Course> courses;
    private int completedEAP;

    public Student(String firstName, String lastName, ZonedDateTime DOB, List<Course> courses, int completedEAP) {
        super(firstName, lastName, DOB);
        this.courses = courses;
        this.completedEAP = completedEAP;
    }
    public List<String> getAllTeacherNames() {
        List<String> teachers = new ArrayList<>();

        for (Course course : courses) {
            teachers.add(course.getTeacherName().getFullName());
        }

        return teachers;
    }
    @Override
    public void sayHello() {
        System.out.println(String.format("Hello, %s", getFullName()));
    }
    public List<Course> getCourses() {
        return courses;
    }

    public int getCompletedEAP() {
        return completedEAP;
    }

    public void setCompletedEAP(int completedEAP) {
        this.completedEAP = completedEAP;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(List<Course> course) {
        this.courses.add((Course) course);
    }
}
