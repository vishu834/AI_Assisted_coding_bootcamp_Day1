import org.junit.Test;
import static org.junit.Assert.*;

public class MissionReportTest {
    @Test
    public void testMissionReportFields() {
        MissionReport report = new MissionReport("Apollo", true, "Success", "Mission Accomplished");
        assertEquals("Apollo", report.getMissionName());
        assertTrue(report.isRiskyLaunch());
        assertEquals("Success", report.getLaunchOutcome());
        assertEquals("Mission Accomplished", report.getFinalOutcome());
    }

    @Test
    public void testMissionReportToString() {
        MissionReport report = new MissionReport("Gemini", false, "Failure", "Abort");
        String expected = "MissionReport{" +
                "missionName='Gemini'" +
                ", riskyLaunch=false" +
                ", launchOutcome='Failure'" +
                ", finalOutcome='Abort'" +
                '}';
        assertEquals(expected, report.toString());
    }
}
