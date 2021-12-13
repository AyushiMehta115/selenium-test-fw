package stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.UniCredsContactUs.UniCredsContactUsPage;
import pages.UniCredsContactUs.ValidationsOfUniCredsContactUsPage;
import pages.UniCredsFillInYourInformation.UniCredsContactUsFillInYourInfoPage;
import utill.UtilityClass;

import javax.security.sasl.SaslClient;

public class StepsHome  {

    private Scenario scenario;

    @Before
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    private final UniCredsContactUsFillInYourInfoPage fillInYourInfoPage = UniCredsContactUsFillInYourInfoPage.getInstance();
    UniCredsContactUsPage uniCredsContactUsPage = new UniCredsContactUsPage();
    ValidationsOfUniCredsContactUsPage validationsOfUniCredsContactUsPage = new ValidationsOfUniCredsContactUsPage();


    @Given("User can launch browser")
    public void launch_Browser_As_User() {

        scenario.log("User should be able to launch browser successfully");
        fillInYourInfoPage.launchBrowserAsUser();
    }

    @When("User opens UniCreds Contact-Us URL")
    public void user_Opens_UniCreds_ContactUs_Page() {
        fillInYourInfoPage.userOpensUniCredsContactUsPage();

        scenario.log("User should be able to open UniCreds Contact-Us Page successfully");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @When("User wait for Fill in your Information form to appear")
    public void user_wait_for_fill_in_your_information_form_to_appear() {
        fillInYourInfoPage.userWaitForFillInYourInformationFormToAppear();

        scenario.log("Fill In Your Information form should appear");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @When("User enters Name as {} and Phone Number as {} and Email as {}")
    public void user_enters_name_and_phone_number_and_email(String Name, String PhoneNumber, String Email) {
        Boolean strfail = fillInYourInfoPage.userEntersNameAndPhoneNumberAndEmail(Name, PhoneNumber, Email);
        if (strfail.equals(true)) {
            Assert.fail("Test Case Resulted in Exception");
        } else {
            System.out.println("Test Case executed. Please see screenshots for more details.");
        }

        scenario.log("User should be able to enter Name, Phone Number and Email");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @When("User enters Loan Amount as {} and selects Country of Study as {}")
    public void user_enters_loan_amount_and_selects_country_of_study(double LoanAmount, String CountryofStudy) {
        Boolean strfail = fillInYourInfoPage.userEntersLoanAmountAndSelectsCountryOfStudy(LoanAmount, CountryofStudy);
        if (strfail.equals(true)) {
            Assert.fail("Test Case Resulted in Exception");
        } else {
            System.out.println("Test Case executed. Please see screenshots for more details.");
        }

        scenario.log("User should be able to enter Loan Amount and select Country of Study");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @When("User selects Appointment Date as {} and Appointment Time as {}")
    public void user_selects_appointment_date_and_appointment_time(String appointmentDate, String appointmentTime) {
        fillInYourInfoPage.userSelectsAppointmentDateAndAppointmentTime(appointmentDate, appointmentTime);

        scenario.log("User should be able to enter Appointment date and Appointment time");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @Then("User clicks on Get OTP button and validates {},{},{}")
    public void user_clicks_on_get_otp_button_and_understands_scenario(String Name, String PhoneNumber, String Email) {
        fillInYourInfoPage.userClicksOnGetOTPButtonAndValidatesAllFields(Name, PhoneNumber, Email);

        scenario.log("User should be able to click on Get OTP Button and Validate Name, Phone Number and Email Fields");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @Then("User clicks on Get OTP button and validates {} and {} field")
    public void user_clicks_on_get_otp_button_and_understands_scenario(double LoanAmount, String countryofStudy) {
        fillInYourInfoPage.userClicksOnGetOTPButtonAndValidatesAllFields(LoanAmount, countryofStudy);

        scenario.log("User should be able to click on Get OTP Button and Validate Loan Amount and Country of Study");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @Then("User clicks on Get OTP button then validates {} and {}")
    public void user_clicks_on_get_otp_button_and_understands_scenario(String appointmentDate, String appointmentTime) {
        fillInYourInfoPage.userClicksOnGetOTPButtonAndValidatesAllFields(appointmentDate, appointmentTime);

        scenario.log("User should be able to click on Get OTP Button And Validates Appointment Date and Appointment Time");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @And("User closes Fill in your Information form")
    public void user_closes_Fill_in_your_Information_form() {
        fillInYourInfoPage.userClosesFillinyourInformationform();

        scenario.log("User should be able to close Fill in your Information form");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }


    /**
     * Contact Us Page
     */
    @When("User validates presence of Full Name, Email Address, Country Code, Phone and Message fields")
    public void userValidatePresence() {
        uniCredsContactUsPage.userValidatePresence();

        scenario.log("User should be able to validate presence of all fields");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @Then("User performs Mandatory field validation")
    public void mandatoryFieldValidation() {
        uniCredsContactUsPage.mandatoryFieldValidation();

        scenario.log("User should be able to validate mandatory fields");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }


    @When("User enters value in Full Name {}")
    public void user_enters_value_in_full_name(String fullName) {
        uniCredsContactUsPage.user_enters_value_in_full_name(fullName);

        scenario.log("User should be able to enter value in Full Name field");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @When("User enters Email Address {}")
    public void user_enters_email_address(String emailAddress) {
        uniCredsContactUsPage.user_enters_email_address(emailAddress);

        scenario.log("User should be able to enter value in Email Address field");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @When("User selects Country Code {}")
    public void user_selects_country_code(String countryCode) {
        uniCredsContactUsPage.user_selects_country_code(countryCode);

        scenario.log("User should be able to select value in Country Code field");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @When("User enters value in Phone {}")
    public void user_enters_value(String phone) throws Exception {
        uniCredsContactUsPage.user_enters_value(phone);

        scenario.log("User should be able to enter value in Phone field");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @When("User enter Message {}")
    public void user_enter_message(String Message) {
        uniCredsContactUsPage.user_enter_message(Message);

        scenario.log("User should be able to enter value in Message field");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @Then("User clicks on Submit button")
    public void user_clicks_on_submit_button() {
        uniCredsContactUsPage.user_clicks_on_submit_button();

        scenario.log("User should be able to submit details on UniCreds Contact Us page");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @Then("User validates Full Name {} field")
    public void validate_Full_Name_Field(String fullName) {
        validationsOfUniCredsContactUsPage.validate_Full_Name_Alphanumeric(fullName);
        validationsOfUniCredsContactUsPage.validate_Full_Name_SpecialCharacters(fullName);
        validationsOfUniCredsContactUsPage.validate_Full_Name_Length(fullName);

        scenario.log("Validation of Name field should be successful");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @Then("User validates Email Address {} field")
    public void validate_Email_Address_Field(String EmailAddress) {
        validationsOfUniCredsContactUsPage.validate_Email_Address(EmailAddress);
        validationsOfUniCredsContactUsPage.validate_Email_Address_consecutivedot(EmailAddress);
        validationsOfUniCredsContactUsPage.validate_Email_Address_trailing_dot(EmailAddress);
        validationsOfUniCredsContactUsPage.validate_Email_Address_DomainNames(EmailAddress);
        //validationsOfUniCredsContactUsPage.validate_Email_Address_format(EmailAddress);

        scenario.log("Validation of Email field should be successful");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @And("User validates Country Code {}")
    public void validatesCountryCodeCountryCode(String countryCode) {
        validationsOfUniCredsContactUsPage.validate_Country_Code_Length(countryCode);

        scenario.log("Validation of Country Code field should be successful");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @And("User validates Phone {} field")
    public void userValidatesPhoneField(String Phone) {
        validationsOfUniCredsContactUsPage.Validates_Phone_Alphabets(Phone);
        validationsOfUniCredsContactUsPage.Validates_Phone_SpecialChars(Phone);
        validationsOfUniCredsContactUsPage.Validates_Phone_length(Phone);

        scenario.log("Validation of Phone field should be successful");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @And("User validates Message {} field")
    public void userValidatesMessageField(String Message) {
        validationsOfUniCredsContactUsPage.validate_Message_length(Message);
        validationsOfUniCredsContactUsPage.validate_Message_Input(Message);

        scenario.log("Validation of Message field should be successful");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @And("User validates if success message appears {}")
    public void userValidatesIfSuccessMessageAppears(String SuccessMessage) {
        uniCredsContactUsPage.validateSuccessMessage(SuccessMessage);

        scenario.log("Validation of Form submission and Success Message should be successful");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());
    }

    @And("User validates appearance of Verify OTP screen")
    public void userValidatesAppearanceOfVerifyOTPScreen() {
        fillInYourInfoPage.userValidatesAppearanceOfVerifyOTPScreen();

        scenario.log("User should validate appearance of Verify OTP screen");
        UtilityClass.captureScreenshotToScenario(scenario, UtilityClass.captureScreenshotOfBrowser());

        scenario.log("Test Case are Passed and completed successfully");
    }
}
