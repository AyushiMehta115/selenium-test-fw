package utill;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testDriver.Shell;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityClass extends Shell {

    //-------Initializing Browser variables.
    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 30;
    public static String ssFolderPath;
    public String userName = System.getProperty("user.name");
    SimpleDateFormat dateFormat;

    //-------Kill the Browser Process (Use on demand)
    public void KillValidBrowserProcess(String browserName) {
        try {
            Runtime.getRuntime().exec("taskkill /im chrome.exe /f /t");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Shell.log.info("Killed all the Chrome browser process");
    }

    //-------Set Current date and Time for Log file
    public void setCurrentDateTime() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd hhmmss");
        System.setProperty("current.date", dateFormat.format(new Date()));
    }

    //-------Delete old log files
    public void deleteOldLogfiles() {
        File file = new File("./src/main/java/logs/");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    public void initializeScreenshotFolder() {

        String screenshotFolderName = "_TestRun_" + dateFormat.format(new Date()) + "\\";

        File file = new File("target\\ExecutionScreenshot\\TC\\");

        String absolutePath = file.getAbsolutePath();

        ssFolderPath = absolutePath + screenshotFolderName;
        Path path = Paths.get(ssFolderPath);

        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void captureScreenshotToScenario(Scenario scenarioToAttach, byte[] imageBytesToAttach) {
        if (ArrayUtils.isNotEmpty(imageBytesToAttach)) {
            attachBytesToScenarioAsImage(scenarioToAttach, imageBytesToAttach);
        }
    }

    private static void attachBytesToScenarioAsImage(Scenario scenarioToAttach, byte[] imageBytesToAttach) {
        scenarioToAttach.attach(imageBytesToAttach, "image/png", "screenshot");
    }

    public static byte[] captureScreenshotOfBrowser() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public File takeScreenshots() {
        File screenshotFile = null;
        try {
            String ssName = "Screenshot_" + dateFormat.format(new Date()) + ".jpg";
            String ssPath = ssFolderPath + ssName;
            screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(ssPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenshotFile;
    }


}
