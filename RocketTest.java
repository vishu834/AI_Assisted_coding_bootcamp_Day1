import org.junit.Test;
import static org.junit.Assert.*;

public class RocketTest {
    @Test
    public void testNotReadyIfFuelLow() {
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(99);
        assertFalse(rocket.verifyReadiness());
    }

    @Test
    public void testReadyIfFuelFull() {
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(100);
        assertTrue(rocket.verifyReadiness());
    }

    @Test
    public void testNotReadyIfFuelEmpty() {
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(0);
        assertFalse(rocket.verifyReadiness());
    }

    @Test
    public void testNotReadyIfOverweight() {
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(100);
        rocket.setMaxWeight(6000); // Assume max weight
        rocket.setFuelToMassRatio(1); // 1 litre = 1 kg
        rocket.setFuelLitres(2000); // 2000 litres
        // base_mass + fuel_mass = 5000 + 2000 = 7000 > 6000
        assertFalse(rocket.verifyReadiness());
    }
}
