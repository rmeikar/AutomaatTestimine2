package University;

import java.time.ZonedDateTime;

public class Course {
    String courseName;
    int EAP;
    String teacherName;
    ZonedDateTime startDate;
    ZonedDateTime endDate;

    public Course(String courseName, int EAP, String teacherName, ZonedDateTime startDate, ZonedDateTime endDate) {
        this.courseName = courseName;
        this.EAP = EAP;
        this.teacherName = teacherName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

