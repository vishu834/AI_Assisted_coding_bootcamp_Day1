import java.util.ArrayList;
import java.util.List;

class Engine {
    private String type;
    private int mass;
    private int liftPower;

    public Engine(String type, int mass, int liftPower) {
        this.type = type;
        this.mass = mass;
        this.liftPower = liftPower;
    }

    public int getMass() {
        return mass;
    }

    public int getLiftPower() {
        return liftPower;
    }
}

public class Rocket {
    private String model;
    private int baseMass;
    private int fuelLevel; // 0-100 percent
    private List<Engine> engines = new ArrayList<>();
    private String status = "Not Ready";
    private List<Integer> cargoHold = new ArrayList<>();

    public Rocket(String model, int baseMass) {
        this.model = model;
        this.baseMass = baseMass;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void addEngine(Engine engine) {
        engines.add(engine);
    }

    public void loadItem(int itemMass) {
        cargoHold.add(itemMass);
    }

    public int getCargoMass() {
        int totalCargo = 0;
        for (int mass : cargoHold) {
            totalCargo += mass;
        }
        return totalCargo;
    }

    public int getLaunchMass() {
        int engineMass = 0;
        for (Engine e : engines) {
            engineMass += e.getMass();
        }
        return baseMass + engineMass + getCargoMass();
    }

    public int getTotalLiftPower() {
        int totalLift = 0;
        for (Engine e : engines) {
            totalLift += e.getLiftPower();
        }
        return totalLift;
    }

    public boolean startLiftoff() {
        if (verifyReadiness()) {
            status = "Launched";
            return true;
        } else {
            status = "Not Ready";
            return false;
        }
    }

    public String getStatus() {
        return status;
    }

    public boolean verifyReadiness() {
        return fuelLevel == 100;
    }
}
