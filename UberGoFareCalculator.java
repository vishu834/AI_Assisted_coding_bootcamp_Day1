// Java class to calculate Uber Go fare
public class UberGoFareCalculator {
    private static final int BASE_PRIZE = 50;
    private static final int PER_KM_RATE = 10;

    public int calculateFare(int km) {
        return BASE_PRIZE + (PER_KM_RATE * km);
    }
}
