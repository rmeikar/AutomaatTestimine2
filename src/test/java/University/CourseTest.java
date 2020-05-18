package University;

import org.junit.Test;
import java.time.ZonedDateTime;
import static org.junit.Assert.assertEquals;

public class CourseTest {
    private Course course = new Course();
    @Test
    public void getWorkingDays_Test() {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-02-01");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2020-04-15");
        course.setStartDate(start);
        course.setEndDate(end);
        assertEquals(53, course.getWorkingDays());
    }
    @Test
    public void getWorkingDays_Multiple_Year_Test() {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-05-05");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2023-10-10");
        course.setStartDate(start);
        course.setEndDate(end);

        assertEquals(879, course.getWorkingDays());
    }
    @Test
    public void getWorkingDays_End_Before_Start_Test() {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-10-20");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2020-10-10");
        course.setStartDate(start);
        course.setEndDate(end);

        assertEquals(-8, course.getWorkingDays());
    }
    @Test
    public void getWorkingDays_Same_Day_Test() {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-05-05");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2020-05-05");
        course.setStartDate(start);
        course.setEndDate(end);

        assertEquals(1, course.getWorkingDays());
    }
}
