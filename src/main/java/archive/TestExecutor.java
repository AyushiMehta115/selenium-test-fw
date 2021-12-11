package archive;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import testDriver.Shell;
import utill.UtilityClass;


import java.util.concurrent.TimeUnit;

public class TestExecutor extends Shell {

	String TRStatus;
	String TCNumber;
	String ModuleName;
	String TestData;
	String TCDescription;

	public TestExecutor(String TRStatus, String TCNumber, String ModuleName, String TestData, String TCDescription) {
		this.TRStatus = TRStatus;
		this.TCNumber = TCNumber;
		this.ModuleName = ModuleName;
		this.TestData = TestData;
		this.TCDescription = TCDescription;
	}

	// Open the browser and initialize its default properties
//	public void Browserinitialization() {
//
//		// -------Getting BrowserName and URL from Property File
//		browserName = prop.getProperty("browser");
//		url = prop.getProperty("url");
//
//		// -------Checking the Browser to be used and opening it
//		if (browserName.equals("Chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\ayushi_mehta\\Downloads\\Selenium Java\\Selenium Web Drivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//			log.info("Chrome Browser Initialized");
//		} else if (browserName.equals("Firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					"E:\\Work\\eclipse-workspace\\Drivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//			log.info("Firefox Browser Intialized");
//		}
//
//		// -------Setting default Browser Settings
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(UtilityClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICIT_WAIT, TimeUnit.SECONDS);
//	}

	// Load application url
	public static void OpenWebApplication() {
		// -------Calling Application URL
		driver.get(url);
	}

	// Run the test case
	public void runTestCase() throws Exception {
		log.info("Executing................");

		// Write test case here.

		utillClass.takeScreenshots();
	}

	// Close all browser
	public void closeBrowser() {
		driver.close();
		log.info("Closing browser");
	}
}
