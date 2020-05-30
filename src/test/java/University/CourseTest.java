package University;

import hello.Counter;
import hello.Greeter;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.time.ZonedDateTime;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
    @Mock
    PublicHolidayService countMock;
    @InjectMocks
    Course courseMock;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void mock_test_one_day() throws IOException, JSONException {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-05-05");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2020-05-05");
        courseMock.setStartDate(start);
        courseMock.setEndDate(end);
        when(countMock.getWeekDayHolidayCount(start, end)).thenReturn(1);
        long result = courseMock.getWorkingDays();
        Assertions.assertEquals(1, result);
    }
    @Test
    public void mock_test_end_before_start_day() throws IOException, JSONException {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-10-20");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2020-10-10");
        courseMock.setStartDate(start);
        courseMock.setEndDate(end);
        when(countMock.getWeekDayHolidayCount(start, end)).thenReturn(-8);
        long result = courseMock.getWorkingDays();
        Assertions.assertEquals(-8, result);
    }
    @Test
    public void mock_test_multiple_years() throws IOException, JSONException {
        ZonedDateTime start = Utils.dateToTypeZoneDateTime("2020-05-05");
        ZonedDateTime end = Utils.dateToTypeZoneDateTime("2023-10-10");
        courseMock.setStartDate(start);
        courseMock.setEndDate(end);
        when(countMock.getWeekDayHolidayCount(start, end)).thenReturn(-8);
        long result = courseMock.getWorkingDays();
        Assertions.assertEquals(875, result);
    }
}
