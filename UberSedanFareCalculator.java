// Java class to calculate Uber Sedan fare
public class UberSedanFareCalculator {
    private static final int BASE_PRIZE = 50;
    private static final int PER_KM_RATE = 15; // Different per km rate for Sedan

    public int calculateFare(int km) {
        return BASE_PRIZE + (PER_KM_RATE * km);
    }
}
