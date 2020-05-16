package University;

import java.time.ZonedDateTime;

public class Teacher extends PersonImpl {

    public Teacher(String firstName, String lastName, ZonedDateTime DOB) {
        super(firstName, lastName, DOB);
    }

    @Override
    public void sayHello() {
        System.out.println(String.format("Hello, Prof.%s", getFullName()));
    }

}