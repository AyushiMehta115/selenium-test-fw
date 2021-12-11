package testDriver;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import utill.UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Shell {

    //-------Initializing class variables
    public static UtilityClass utillClass;
    public static Logger log;
    public static Properties prop;
    public static WebDriver driver;
    public static String browserName;
    public static String url;

    //-------Calling basic Log functions in static block
    static {
        utillClass = new UtilityClass();
        utillClass.setCurrentDateTime();
        utillClass.deleteOldLogfiles();

        //-------Config Log4j Property file
        PropertyConfigurator.configure("./src/main/java/config/Log4j.properties");
        log = Logger.getLogger("MyFW");
    }

    public File file;
    public String PropertyFilePath = ("./src/main/java/config/config.properties");

    //-------importing configuration files in Constructor
    public Shell() {
        try {
            prop = new Properties();
            FileInputStream fip = new FileInputStream(PropertyFilePath);
            prop.load(fip);
        } catch (Exception e) {
            System.out.println("Config file not found");
            e.printStackTrace();
        }
    }

    public static void OpenWebApplication() {
        driver.get(url);
    }

    //-------Run the test Suite
    public static void runTestSuite() {
        Shell.log.info("Executing Test Suite");

        //-------Write test case here.


        Shell.utillClass.takeScreenshots();
    }
}
