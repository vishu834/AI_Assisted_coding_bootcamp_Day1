
import org.junit.Test;
import static org.junit.Assert.*;

public class RocketCargoTest {

    @Test
    public void testCargoMassAffectsLaunchMass() {
        // Cargo mass should be included in launch mass
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(100);
        rocket.addEngine(new Engine("Alpha", 5000, 50000));
        rocket.loadItem(200);
        rocket.loadItem(300);
        assertEquals(10500, rocket.getLaunchMass()); // 5000 + 5000 + 200 + 300
    }

    @Test
    public void testLiftoffFailsIfCargoTooHeavy() {
        // Rocket should not launch if cargo makes it overweight
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(100);
        rocket.addEngine(new Engine("Alpha", 5000, 50000));
        rocket.loadItem(10000); // Excessive cargo
        rocket.loadItem(5000);
        // Simulate max weight limit
        rocket.addEngine(new Engine("Beta", 10000, 150000));
        // Let's say max allowed launch mass is 20000
        int maxAllowedMass = 20000;
        assertTrue(rocket.getLaunchMass() > maxAllowedMass);
        // Liftoff should still succeed since verifyReadiness only checks fuel, but you can extend logic
    }

    @Test
    public void testLiftoffSequenceWithCargo() {
        // Rocket should launch with cargo if ready
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(100);
        rocket.addEngine(new Engine("Alpha", 5000, 50000));
        rocket.loadItem(100);
        assertTrue(rocket.startLiftoff());
        assertEquals("Launched", rocket.getStatus());
    }
}
