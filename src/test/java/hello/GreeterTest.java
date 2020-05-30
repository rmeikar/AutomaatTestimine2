package hello;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)
public class GreeterTest {

    @Mock
    Counter counter;
    @InjectMocks
    Greeter greeter;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testNorm() {
        when(counter.nameLength("Robert")).thenReturn(6);
        String result = greeter.sayHello("Robert");
        Assertions.assertEquals("Hello Robert, your name is 6 letters long!", result);
    }
    @Test
    public void testNull() {
        when(counter.nameLength("")).thenReturn(0);
        String result = greeter.sayHello("");
        Assertions.assertEquals("Hello , your name is 0 letters long!", result);
    }
    @Test
    public void testNumbers() {
        when(counter.nameLength("1337")).thenReturn(4);
        String result = greeter.sayHello("1337");
        Assertions.assertEquals("Hello 1337, your name is 4 letters long!", result);
    }
    @Test
    public void testWeird() {
        when(counter.nameLength("~'õü+`@")).thenReturn(7);
        String result = greeter.sayHello("~'õü+`@");
        Assertions.assertEquals("Hello ~'õü+`@, your name is 7 letters long!", result);
    }


}