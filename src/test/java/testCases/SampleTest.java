package testCases;


import archive.ReadAndExecutefn;
import cucumber.api.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testActions.SampleAction;
import testDriver.Shell;
import utill.TestCompletion;
import utill.TestInitilization;



public class SampleTest extends Shell {
	@BeforeTest
	public void beforeTest() {
		TestInitilization.testInitialization();
	}

	@CucumberOptions(
			features =
					tags =

	)
	@Test
	public void test1() {
		// ------Read Test cases to be executed
		try {
			//ReadAndExecutefn.readAndExecuteTestcases();

			runTestSuite();
			OpenWebApplication();
			SampleAction.sampleMethod();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest() {
		TestCompletion.testCompletion();
		
	}

}
