package University;

import org.json.JSONException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

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

    public Course() {

    }

    public long getWorkingDays() throws IOException, JSONException {
        LocalDate start = startDate.toLocalDate();
        LocalDate end = endDate.toLocalDate().plusDays(1);

        int startW = start.getDayOfWeek().getValue();
        int endW = end.getDayOfWeek().getValue();

        long days = ChronoUnit.DAYS.between(start, end);
        long result = days - 2 * (days / 7); //remove weekends

        if (days % 7 != 0) { //deal with the rest days
            if (startW == 7) {
                result -= 1;
            } else if (endW == 7) {  //they can't both be Sunday, otherwise rest would be zero
                result -= 1;
            } else if (endW < startW) { //another weekend is included
                result -= 2;
            }
        }
        return result - Utils.countHolidays(startDate, endDate);
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

