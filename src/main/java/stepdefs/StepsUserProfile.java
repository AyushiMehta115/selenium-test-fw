package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utill.TestCompletion;


public class StepsUserProfile {

    private Scenario scenario;

    @Before
    public void setScenario(Scenario scenario) {
        System.out.println("before test");
        this.scenario = scenario;
    }

    @After
    public void afterScenario() {
        System.out.println("after test");
        TestCompletion.closeBrowser();
    }

}
