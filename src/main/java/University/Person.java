package University;

import java.time.ZonedDateTime;

public interface Person {

    String getFirstName();

    String getLastName();

    String getFullName();

    ZonedDateTime getDOB();

    long getAge();

    void sayHello();
}