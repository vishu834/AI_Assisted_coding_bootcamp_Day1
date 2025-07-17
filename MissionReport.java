public class MissionReport {
    private String missionName;
    private boolean riskyLaunch;
    private String launchOutcome;
    private String finalOutcome;

    public MissionReport(String missionName, boolean riskyLaunch, String launchOutcome, String finalOutcome) {
        this.missionName = missionName;
        this.riskyLaunch = riskyLaunch;
        this.launchOutcome = launchOutcome;
        this.finalOutcome = finalOutcome;
    }

    public String getMissionName() {
        return missionName;
    }

    public boolean isRiskyLaunch() {
        return riskyLaunch;
    }

    public String getLaunchOutcome() {
        return launchOutcome;
    }

    public String getFinalOutcome() {
        return finalOutcome;
    }

    @Override
    public String toString() {
        return "MissionReport{" +
                "missionName='" + missionName + '\'' +
                ", riskyLaunch=" + riskyLaunch +
                ", launchOutcome='" + launchOutcome + '\'' +
                ", finalOutcome='" + finalOutcome + '\'' +
                '}';
    }
}
