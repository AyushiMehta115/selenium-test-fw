package utill;

import testDriver.Shell;

public class TestCompletion extends Shell {

    public static void testCompletion() {
        //-------Closing the Automation session
        quitBrowser();

        System.out.println("========================================================================================");
        System.out.println("                         Wrapping Test Execution                                      ");
        System.out.println("========================================================================================");
    }

    //-------Close all browser
    public static void closeBrowser() {
        driver.close();
        log.info("Closing browser");
    }

    //-------Quit browsers
    public static void quitBrowser() {
        driver.quit();
        log.info("Quiting browser");
    }

}
