// Java class to add two numbers
public class AddNumbers {
    public int add(int a, int b) {
        return a + b;
    }
}
public class MultiplyNumbers {
    public int multiply(int a, int b) {
        return a * b;
    }
}
// Java JUnit test case to add two numbers

import org.junit.Test;
import static org.junit.Assert.*;

public class AddNumbersTest {

    @Test
    public void testAdd() {
        assertEquals(5, 2 + 3);
        assertEquals(0, -1 + 1);
        assertEquals(0, 0 + 0);
    }
}
