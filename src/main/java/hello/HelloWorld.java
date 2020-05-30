package hello;

import org.joda.time.LocalTime;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        Scanner scan = new Scanner(System.in);
        System.out.println("The current local time is: " + currentTime);
        Greeter greeter = new Greeter();
        System.out.println("What is your name?");
        System.out.println(greeter.sayHello(scan.nextLine()));
    }
}