package hello;

public class Greeter {
    public String sayHello(String name) {
        Counter counter = new Counter();
        return String.format("Hello %s, your name is %d letters long!", name, counter.nameLength(name));
    }
}