package pages.UniCredsFillInYourInformation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testDriver.Shell;
import utill.TestInitilization;

import java.util.concurrent.TimeUnit;

public class UniCredsContactUsFillInYourInfoPage extends Shell {

    private static final ThreadLocal<UniCredsContactUsFillInYourInfoPage> instancePage = ThreadLocal.withInitial(UniCredsContactUsFillInYourInfoPage::new);
    ValidationsOfFillInYourInformationPage validations = new ValidationsOfFillInYourInformationPage();

    public static UniCredsContactUsFillInYourInfoPage getInstance() {
        return instancePage.get();
    }

    /**
     * @Given("User can launch browser")
     */
    public void launchBrowserAsUser() {
        try {
            TestInitilization.testInitialization();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @When("User opens UniCreds Contact-Us URL")
     */
    public void userOpensUniCredsContactUsPage() {
        try {
            Shell.OpenWebApplication();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @When("User wait for Fill in your Information form to appear")
     */

    public void userWaitForFillInYourInformationFormToAppear() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 100);

            WebElement notificationPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onesignal-slidedown-cancel-button")));

            if (notificationPopUp.isDisplayed()) {
                notificationPopUp.click();
                log.info("notification popup is closed");
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/h3")).isDisplayed();
            log.info("Fill in your Information form is displayed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param Name
     * @param PhoneNumber
     * @param Email
     * @When("User enters Name as {} and Phone Number as {} and Email as {}")
     **/
    public boolean userEntersNameAndPhoneNumberAndEmail(String Name, String PhoneNumber, String Email) {
        boolean strfail = false;
        try {
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

            if (driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/h3")).isDisplayed()) {

                log.info("Enter Name, Phone Number, Email Address");

                //Name field Validation
                driver.findElement(By.id("name")).sendKeys(Name);


                //Phone Number field validation
                driver.findElement(By.id("phoneNumber")).sendKeys(PhoneNumber);


                //Email field validation
                driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[1]/div/label/input")).sendKeys(Email);


            } else {
                log.info("Fill in your Information popup did not appear");
            }

        } catch (Exception e) {
            e.printStackTrace();
            strfail = true;
        }
        return strfail;
    }

    /**
     * @param LoanAmount
     * @param CountryofStudy
     * @When("User enters Loan Amount as {} and selects Country of Study as {}")
     */
    public boolean userEntersLoanAmountAndSelectsCountryOfStudy(double LoanAmount, String CountryofStudy) {
        boolean strfail = false;
        try {
            if (driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/h3")).isDisplayed()) {
                String loanAmount = String.valueOf(LoanAmount);
                log.info("enters loan amount and country of study");

                //Loan Amount validation
                driver.findElement(By.id("loan_amount")).sendKeys(loanAmount);


                driver.findElement(By.id("react-select-2-input")).sendKeys(CountryofStudy);

                WebDriverWait wait = new WebDriverWait(driver, 20);

                WebElement countryOfStudy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,\"css-2rz9ep-menu\")]")));
                countryOfStudy.click();


            } else {
                log.info("Fill in your Information popup did not appear");
            }

        } catch (Exception e) {
            e.printStackTrace();
            strfail = true;
        }

        return strfail;
    }

    /**
     * @param AppointmentDate
     * @param AppointmentTime
     * @When("User selects Appointment Date as {} and Appointment Time as {}")
     */
    public void userSelectsAppointmentDateAndAppointmentTime(String AppointmentDate, String AppointmentTime) {

        try {
            driver.findElement(By.name("appointment_date")).click();

            if (driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[4]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[@aria-disabled=\"false\"]")).isDisplayed()) {
                driver.findElement(By.name("appointment_date")).sendKeys(AppointmentDate);


                if (driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[4]/div[2]/div[1]/div/div[1]/div[1]")).isEnabled()) {
                    driver.findElement(By.id("react-select-3-input")).sendKeys(AppointmentTime);

                    WebDriverWait wait = new WebDriverWait(driver, 20);

                    WebElement appointmentTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,\"css-2rz9ep-menu\")]")));
                    appointmentTime.click();
                }

            } else {
                log.info("Selected Date and Time is disabled for selection");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Then("User clicks on Get OTP button and understands scenario as {}")
     */
    public void userClicksOnGetOTPButtonAndValidatesAllFields(String Name, String PhoneNumber, String Email) {
        try {
            driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/button")).click();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            validations.validateName(Name);
            validations.validatePhoneNumber(PhoneNumber);
            validations.validateEmail(Email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param LoanAmount
     */
    public void userClicksOnGetOTPButtonAndValidatesAllFields(double LoanAmount, String countryofStudy) {
        try {
            validations.validateLoanAmount(LoanAmount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userClicksOnGetOTPButtonAndValidatesAllFields(String appointmentDate, String appointmentTime) {
        try {
            validations.validateAppointmentDateTime(appointmentDate, appointmentTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userValidatesAppearanceOfVerifyOTPScreen(){
        try {
            if(!driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/div[2]/h2")).isEmpty()){
                log.info("Correct values are entered in all fields on 'Fill in your information' page");
            } else{
                log.info("Incorrect values are entered on 'Fill in your information' page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userClosesFillinyourInformationform() {

        if (driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/h3")).isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/button")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            log.info("Fill in your Information popup is closed");
        } else {
            log.info("Fill in your Information popup did not appear");
        }
    }
}
