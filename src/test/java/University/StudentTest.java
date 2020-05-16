package University;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Test
    public void get_teachers_names_test() {

        Teacher teacher1 = new Teacher("John", "Smith", Utils.dateToTypeZoneDateTime("1976-12-12"));
        Teacher teacher2 = new Teacher("Mary", "Sue", Utils.dateToTypeZoneDateTime("1966-01-05"));
        Teacher teacher3 = new Teacher("Joe", "Doe", Utils.dateToTypeZoneDateTime("1983-10-10"));

        Course course1 = new Course("Suhtlemine", 3, teacher1, Utils.dateToTypeZoneDateTime("2017-09-01"), Utils.dateToTypeZoneDateTime("2018-02-11"));
        Course course2 = new Course("Progremine", 6, teacher2, Utils.dateToTypeZoneDateTime("2017-09-01"), Utils.dateToTypeZoneDateTime("2018-02-11"));
        Course course3 = new Course("Jooksmine", 3, teacher3, Utils.dateToTypeZoneDateTime("2017-09-01"), Utils.dateToTypeZoneDateTime("2018-02-11"));

        Student student = new Student("Timmy", "Troublesome", Utils.dateToTypeZoneDateTime("2000-01-01"), Arrays.asList(course1, course2, course3), 12);

        List<String> teachers = student.getAllTeacherNames();

        assertEquals("John Smith", teachers.get(0));
        assertEquals("Mary Sue", teachers.get(1));
        assertEquals("Joe Doe", teachers.get(2));
    }

    @Test
    public void get_courses_test(){
        Teacher teacher1 = new Teacher("Gary", "Sue", Utils.dateToTypeZoneDateTime("1983-10-10"));
        Teacher teacher2 = new Teacher("Joe", "Moe", Utils.dateToTypeZoneDateTime("1983-10-10"));
        Teacher teacher3 = new Teacher("Fritz", "Kritz", Utils.dateToTypeZoneDateTime("1983-10-10"));

        Course course1 = new Course("Tennis", 3, teacher1, Utils.dateToTypeZoneDateTime("2017-09-01"), Utils.dateToTypeZoneDateTime("2018-02-11"));
        Course course2 = new Course("Meemika", 9, teacher2, Utils.dateToTypeZoneDateTime("2017-09-01"), Utils.dateToTypeZoneDateTime("2018-02-11"));
        Course course3 = new Course("Finants", 6, teacher3, Utils.dateToTypeZoneDateTime("2017-09-01"), Utils.dateToTypeZoneDateTime("2018-02-11"));

        Student student = new Student("Timmy", "Troublesome", Utils.dateToTypeZoneDateTime("1983-11-11"), Arrays.asList(course1, course2, course3), 15);

        assertEquals(course1, student.getCourses().get(0));
        assertEquals(course2, student.getCourses().get(1));
        assertEquals(course3, student.getCourses().get(2));
    }

}
