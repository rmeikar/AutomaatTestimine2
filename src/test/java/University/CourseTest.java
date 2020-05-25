package University;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.time.ZonedDateTime;
import static org.junit.Assert.assertEquals;

public class CourseTest {
    private Course course = new Course();
    @Test
    public void getWorkingDays_Test() throws IOException, JSONException {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-01-01");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2020-01-03");
        course.setStartDate(start);
        course.setEndDate(end);
        assertEquals(2, course.getWorkingDays());
    }
    @Test
    public void getWorkingDays_Multiple_Year_Test() throws IOException, JSONException {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-05-05");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2023-10-10");
        course.setStartDate(start);
        course.setEndDate(end);

        assertEquals(875, course.getWorkingDays());
    }
    @Test
    public void getWorkingDays_End_Before_Start_Test() throws IOException, JSONException {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-10-20");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2020-10-10");
        course.setStartDate(start);
        course.setEndDate(end);

        assertEquals(-8, course.getWorkingDays());
    }
    @Test
    public void getWorkingDays_Same_Day_Test() throws IOException, JSONException {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-05-05");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2020-05-05");
        course.setStartDate(start);
        course.setEndDate(end);

        assertEquals(1, course.getWorkingDays());
    }
    @Test
    public void getHolidayCount_test() throws IOException, JSONException {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-01-05");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2021-12-30");
        PublicHolidayService holidayService = new PublicHolidayService();
        assertEquals(15 ,holidayService.getWeekDayHolidayCount(start, end));
    }
}
