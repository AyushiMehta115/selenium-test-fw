package utill;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import testDriver.Shell;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestInitilization extends Shell {

    public static void testInitialization() {

        System.out.println("========================================================================================");
        System.out.println("                         Commencing Test Execution                                      ");
        System.out.println("========================================================================================");

        //-------initializing screenshot folder.
        utillClass.initializeScreenshotFolder();

        //-------Calling Driver Class
        log.info("Initiating Drivers");
        browserInitialization();
    }

    public static void browserInitialization() {

        //-------Getting BrowserName and URL from Property File
        browserName = prop.getProperty("browser");
        url = prop.getProperty("url");

        //-------Killing all existing chrome browser
        utillClass.KillValidBrowserProcess(browserName);

        //-------Checking the Browser to be used and opening it
        if (browserName.equalsIgnoreCase("Chrome")) {

            File file = new File("src/test/resources/webdrivers/chromedriver.exe");
            String absolutePath = file.getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", absolutePath);

            driver = new ChromeDriver();
            Shell.log.info("Chrome Browser Initialized Successfully");

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            File file = new File("src/test/resources/webdrivers/geckodriver.exe");
            String absolutePath = file.getAbsolutePath();

            System.setProperty("webdriver.gecko.driver", absolutePath);
            driver = new FirefoxDriver();
            Shell.log.info("Firefox Browser Intialized Successfully");
        }

        //-------Setting default Browser Settings
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(UtilityClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

}
