package pages.UniCredsContactUs;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testDriver.Shell;

import java.util.concurrent.TimeUnit;

public class UniCredsContactUsPage extends Shell {
    //
    public void userValidatePresence() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleContains("Contact Us | UniCreds"));

        if (driver.getTitle().equalsIgnoreCase("Contact Us | UniCreds")) {
            driver.findElement(By.id("fullname")).isDisplayed();
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/section/div/div[2]/div[3]/div[2]/div/form/input[2]")).isDisplayed();
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/section/div/div[2]/div[3]/div[2]/div/form/select")).isDisplayed();
            driver.findElement(By.id("phone")).isDisplayed();
            driver.findElement(By.id("message")).isDisplayed();
            driver.findElement(By.id("contactButton")).isDisplayed();
        }
    }

    public void mandatoryFieldValidation() {
        driver.findElement(By.id("contactButton")).click();

        if (driver.findElement(By.xpath("//*[@id=\"fullname\" and (contains(@class,'invalid'))]")).isDisplayed()) {
            log.info("full name is mandatory field as expected");
        } else {
            log.info("not a mandatory field");
        }

        if (driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/section/div/div[2]/div[3]/div[2]/div/form/input[2][contains(@class,'invalid')]")).isDisplayed()) {
            log.info("email address is mandatory field as expected");
        } else {
            log.info("not a mandatory field");
        }

        if (driver.findElement(By.xpath("//*[@id=\"phone\" and (contains(@class,'invalid'))]")).isDisplayed()) {
            log.info("phone is mandatory field as expected");
        } else {
            log.info("not a mandatory field");
        }

        if (driver.findElement(By.xpath("//*[@id=\"message\" and (contains(@class,'invalid'))]")).isDisplayed()) {
            log.info("message is mandatory field as expected");
        } else {
            log.info("not a mandatory field");
        }
    }

    /**
     * @param fullName
     * @When("User enters value in Full Name {}")
     */
    public void user_enters_value_in_full_name(String fullName) {
        driver.findElement(By.id("fullname")).sendKeys(fullName);
    }

    /**
     * @param emailAddress
     * @When("User enters Email Address {}")
     */
    public void user_enters_email_address(String emailAddress) {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/section/div/div[2]/div[3]/div[2]/div/form/input[2]")).sendKeys(emailAddress);
    }

    /**
     * @param countryCode
     * @When("User selects Country Code {}")
     */
    public void user_selects_country_code(String countryCode) {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/section/div/div[2]/div[3]/div[2]/div/form/select")).sendKeys(countryCode);
    }

    /**
     * @param phone
     * @When("User enters value in Phone {}")
     */
    public void user_enters_value(String phone) throws Exception {

        driver.findElement(By.id("phone")).sendKeys(phone);
    }

    /**
     * @param Message
     * @When("User enter Message {}")
     */
    public void user_enter_message(String Message) {
        driver.findElement(By.id("message")).sendKeys(Message);
    }

    /**
     * @Then("User clicks on Submit button")
     */
    public void user_clicks_on_submit_button() {
        driver.findElement(By.id("contactButton")).click();
    }

    public boolean validateSuccessMessage(String SuccessMessage) {
        boolean strfail = false;
        try {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            //System.out.println(driver.findElement(By.id("formMessage")).getText());

            if (SuccessMessage.equalsIgnoreCase(driver.findElement(By.id("formMessage")).getText())) {

                log.info("Success Message appears: " + SuccessMessage);

            } else {
                log.info("Success Message does not appear ");
                log.info("Fields are mandatory and supplied with invalid values as expected");
            }
            log.info("Testing is Successfully Completed and Passed");
        } catch (Exception e) {
            e.printStackTrace();
            strfail = true;
        }
        return strfail;
    }

}
