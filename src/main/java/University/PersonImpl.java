package University;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class PersonImpl implements Person {

    String firstName;
    String lastName;
    String fullName;
    ZonedDateTime DOB;

    public PersonImpl(String firstName, String lastName, ZonedDateTime DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.DOB = DOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public ZonedDateTime getDOB() {
        return DOB;
    }

    public long getAge() {
        return ChronoUnit.YEARS.between(this.DOB, ZonedDateTime.now());
    }

    public void sayHello() {
    }
}
