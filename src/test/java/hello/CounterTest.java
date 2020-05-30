package hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CounterTest {
    @ParameterizedTest(name = "string={0}, expResult={1}")
    @CsvSource({"Robert, 6", ", 0", "Ka33m/, 6", "a, 1", "Korolla-Mõõdik, 14"})
    public void test(String name, int expResult) {
        Counter counter = new Counter();
        int result = counter.nameLength(name);
        Assertions.assertEquals(expResult, result);
    }
}
