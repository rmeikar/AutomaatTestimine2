package University;

import java.time.ZonedDateTime;

public class Course {
    private String courseName;
    private int EAP;
    private Teacher teacherName;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    public Course(String courseName, int EAP, Teacher teacherName, ZonedDateTime startDate, ZonedDateTime endDate) {
        this.courseName = courseName;
        this.EAP = EAP;
        this.teacherName = teacherName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getEAP() {
        return EAP;
    }

    public void setEAP(int EAP) {
        this.EAP = EAP;
    }

    public Teacher getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(Teacher teacherName) {
        this.teacherName = teacherName;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }
}

