import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class UberGoFareCalculatorTest {
    @Test
    @DisplayName("Should calculate correct fare for given kilometers")
    public void testCalculateFare() {
        UberGoFareCalculator calculator = new UberGoFareCalculator();
        assertEquals(60, calculator.calculateFare(1)); // 50 + 10*1
        assertEquals(100, calculator.calculateFare(5)); // 50 + 10*5
        assertEquals(50, calculator.calculateFare(0)); // 50 + 10*0
    }
}
