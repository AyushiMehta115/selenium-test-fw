package pages.UniCredsFillInYourInformation;

import org.openqa.selenium.By;
import testDriver.Shell;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationsOfFillInYourInformationPage extends Shell {

    public void validateName(String name) {

        //boolean errorPresence = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[1]/div[2][contains(text(),'Please enter only alphabets.')]")).isDisplayed();
        String errorPresence = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[1]/div[2]")).getText();

        if (errorPresence.length() > 1) {
            System.out.println("Name contains Alphanumeric characters gives Error Message as Expected:- " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[1]/div[2]")).getText());

        } else {
            System.out.println("Name contains alphabets as Expected with No Error Message. " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[1]/div[2]")).getText());
        }
        log.info("Test Case for Name Validation is completed");
    }

    public void validatePhoneNumber(String PhoneNumber) {
        //boolean errorPresence = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div[2][contains(text(),'Phone number should have 10 digits.')]")).isDisplayed();

        String errorPresence = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div[2]")).getText();

        if (errorPresence.length() > 1) {
            if (PhoneNumber.length() > 10) {
                System.out.println("Number of digits in Phone Number is greater than 10 which gives Error Message as Expected:- " +
                        driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div[2]")).getText());

            } else if (PhoneNumber.length() < 10) {
                System.out.println("Number of digits in Phone Number is less than 10 which gives Error Message as Expected:- " +
                        driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div[2]")).getText());
            }

        } else {
            System.out.println("Number of digits in Phone Number is equal to 10 as expected with no Error Message. " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div[2]")).getText());
        }
        log.info("Test Case for Phone Number Validation is completed");
    }

    public void validateEmail(String EmailAddress) {

        //boolean errorPresence = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[2][contains(text(),'Please enter an email address.')]")).isDisplayed();
        String errorPresence = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[2]")).getText();
        if (errorPresence.length() > 1) {
            System.out.println("Email Address is invalid or incomplete as expected which gives Error Message as Expected:- " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[2]")).getText());
        } else {
            System.out.println("Email address is as expected with No Error Message. " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[2]/div/div[2]")).getText());
        }
        log.info("Test Case for Email Validation is completed");
    }

    public void validateLoanAmount(double LoanAmount) {

        if (LoanAmount == 1000) {
            System.out.println("Loan Amount is equal to 1000 which should be acceptable by this field as expected with No Error message. " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div[1]/div[2]")).getText());

        } else if (LoanAmount > 1000 && LoanAmount < 100000000) {
            System.out.println("Loan Amount is greater than 1000 and less than 10 crore which should be acceptable by this field as Expected. " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div[1]/div[2]")).getText());

        } else if (LoanAmount == 100000000) {
            System.out.println("Loan Amount is equal to 10 crore which should be acceptable by this field as expected with No Error message. " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div[1]/div[2]")).getText());

        } else {
            System.out.println("Loan Amount is less than 1000 or greater than 10 crore which should not be acceptable and gives Error Message as expected:- " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div/div[1]/div[2]")).getText());
        }

        String element = driver.findElement(By.xpath("//*[@id=\"loan_amount\"]")).getAttribute("value");
        System.out.println("Expected Value inputted in Loan Amount field = " + LoanAmount + "\nActual Value entered on WebPage = " + element);
    }

    public void validateAppointmentDateTime(String appointmentDate, String appointmentTime) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(new Date());

        if (driver.findElement(By.name("appointment_date")).getText().isEmpty()) {
            driver.findElement(By.name("appointment_date")).sendKeys(date);
            log.info("Appointment date is defaulted to today's date");
        }

        String errorPresence = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[4]/div[2]/div[2]")).getText();
        if (errorPresence.length() > 1) {
            System.out.println("Appointment Time is not selected correctly which gives Error Message as Expected:- " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div[2]")).getText());

        } else {
            System.out.println("Appointment Time is selected correctly which gives No Error Message as Expected. " +
                    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div[2]")).getText());
        }
    }


}

