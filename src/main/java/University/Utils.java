package University;

import java.time.ZonedDateTime;
import java.util.List;

public class Utils {
    public static void printStudentNameList(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getFullName());
        }
    }

    public static ZonedDateTime dateToTypeZoneDateTime(String date_yyyy_MM_dd) {
        return ZonedDateTime.parse(String.format("%sT00:00:00+00:00[UTC]", date_yyyy_MM_dd));
    }

    public static int countHolidays(ZonedDateTime startDay, ZonedDateTime finalDay) {
        PublicHolidayService holidayService = new PublicHolidayService();
        return holidayService.getWeekDayHolidayCount(startDay, finalDay);
    }
}
