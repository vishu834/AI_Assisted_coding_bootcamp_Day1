
import org.junit.Test;
import static org.junit.Assert.*;

public class RocketEngineTest {

    @Test
    public void testAddAlphaEngine() {
        // Test adding Alpha engine: launch mass should be base mass + engine mass, lift power should match engine
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(100);
        rocket.addEngine(new Engine("Alpha", 5000, 50000));
        assertEquals(10000, rocket.getLaunchMass()); // 5000 + 5000
        assertEquals(50000, rocket.getTotalLiftPower()); // Alpha engine lift power
    }

    @Test
    public void testAddBetaEngine() {
        // Test adding Beta engine: launch mass should be base mass + engine mass, lift power should match engine
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(100);
        rocket.addEngine(new Engine("Beta", 10000, 150000));
        assertEquals(15000, rocket.getLaunchMass()); // 5000 + 10000
        assertEquals(150000, rocket.getTotalLiftPower()); // Beta engine lift power
    }

    @Test
    public void testAddBothEngines() {
        // Test adding both engines: launch mass and lift power should be sum of all engines
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(100);
        rocket.addEngine(new Engine("Alpha", 5000, 50000));
        rocket.addEngine(new Engine("Beta", 10000, 150000));
        assertEquals(20000, rocket.getLaunchMass()); // 5000 + 5000 + 10000
        assertEquals(200000, rocket.getTotalLiftPower()); // 50000 + 150000
    }

    @Test
    public void testLiftoffSequenceReady() {
        // Test liftoff sequence: should launch if rocket is ready
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(100);
        rocket.addEngine(new Engine("Alpha", 5000, 50000));
        assertTrue(rocket.startLiftoff()); // Should succeed if ready
        assertEquals("Launched", rocket.getStatus()); // Status should update
    }

    @Test
    public void testLiftoffSequenceNotReady() {
        // Test liftoff sequence: should not launch if rocket is not ready
        Rocket rocket = new Rocket("Explorer-1", 5000);
        rocket.setFuelLevel(50);
        rocket.addEngine(new Engine("Alpha", 5000, 50000));
        assertFalse(rocket.startLiftoff()); // Should fail if not ready
        assertEquals("Not Ready", rocket.getStatus()); // Status should update
    }
}
