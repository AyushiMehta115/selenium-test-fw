package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testDriver.Shell;
import utill.TestCompletion;
import utill.UtilityClass;


public class StepsUserProfile {

    protected Scenario scenario;

    @Before
    public void setScenario(Scenario scenario) {
        System.out.println("Before test run");
        this.scenario = scenario;
    }

    @After
    public void afterScenario() {
        System.out.println("After test run");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
        Shell.utillClass.takeScreenshots();
        TestCompletion.closeBrowser();
    }

}
