package testCases;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import testDriver.Shell;
import utill.TestCompletion;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@QAContactTest",
        glue = {"stepdefs"},
        plugin = {"pretty", "html:target/cucumber-reports.html",
                "json:target/cucumber.json"})

public class Test_CucumberTestNG_SetUniCreds extends Shell {
    @BeforeClass
    public static void setup() {
        System.out.println("Before Class method");
        //TestInitilization.testInitialization();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("After Class method");
        TestCompletion.testCompletion();

    }

}
