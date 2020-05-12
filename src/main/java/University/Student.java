package University;

import java.time.ZonedDateTime;

public class Student {
    String name;
    ZonedDateTime DOB;
    String course;
    int completedEAP;

    public Student(String name, ZonedDateTime DOB, String course, int completedEAP) {
        this.name = name;
        this.DOB = DOB;
        this.course = course;
        this.completedEAP = completedEAP;
    }
}
