import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class UberSedanFareCalculatorTest {
    @Test
    @DisplayName("Should calculate correct fare for Uber Sedan for given kilometers")
    public void testCalculateFare() {
        UberSedanFareCalculator calculator = new UberSedanFareCalculator();
        assertEquals(65, calculator.calculateFare(1)); // 50 + 15*1
        assertEquals(125, calculator.calculateFare(5)); // 50 + 15*5
        assertEquals(50, calculator.calculateFare(0)); // 50 + 15*0
    }
}
