package pages.UniCredsContactUs;

import testDriver.Shell;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationsOfUniCredsContactUsPage extends Shell {
    String specialCharacters = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~";

    /**
     * Full Name validation on UniCreds Contact Us page
     *
     * @param fullName
     */
    public void validate_Full_Name_Alphanumeric(String fullName) {

        try {
            //-------convert String to char to traverse through each letter of String
            if (fullName.length() >= 1) {
                char[] chars = fullName.toCharArray();
                StringBuilder sb = new StringBuilder();
                for (char c : chars) {
                    if (Character.isDigit(c)) {
                        sb.append(c);
                    }
                }
                log.info("Numeric characters: " + sb);

                if (sb.toString().matches("[0-9]+")) {
                    log.info("Full Name contains Numeric characters: " + fullName);
                } else {
                    log.info("Full name does not contain Numeric characters: " + fullName);
                }
            }
            log.info("Test Case for Numeric chars validation in Name field is Passed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void validate_Full_Name_SpecialCharacters(String fullName) {

        try {
            //-------mention all special characters as per business requirement
            String specialCharacters = "!#$%&'()*+,-/:;<=>?@[]^_`{|}~";
            String acceptableCharacter = " .";

            //-------Start traversing the string
            String str[] = fullName.split("");

            //-------Initialize count variable
            int count = 0;
            for (int i = 0; i < str.length; i++) {
                if (specialCharacters.contains(str[i])) {
                    count++;
                }
            }

            //-------If given count is 0
            //-------print the given string
            if (fullName != null && count == 0) {
                log.info("Name field does not contain special characters: " + fullName);

            } else {
                log.info("Name field contains special characters: " + fullName);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void validate_Full_Name_Length(String fullName) {

        try {
            //-------length of name field
            if (fullName.length() > 0 && fullName.length() <= 100) {
                log.info("Full name variable length has value > 0 and < 100");

            } else {
                log.info("Full name variable length has null or value > 100");
            }
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Special character validation on Contact Us page
     *
     * @param emailAddress
     */
    public void validate_Email_Address(String emailAddress) {
        try {
            int count = 0;
            for (int i = 0; i < emailAddress.length(); i++) {

                //-------Increment i if current char is equal to given character
                if (emailAddress.charAt(i) == '@') {
                    count++;
                }
            }
            //-------If Email address contains more than one @ character
            if (count > 1) {
                log.info("Email address contains more than one @ character which is invalid. Count: " + count);
            } else if (count == 1) {
                log.info("Email address contains only one @ character which is as expected");
            } else {
                log.info("Email address does not contain @ character which is invalid");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void validate_Email_Address_consecutivedot(String emailAddress) {
        try {
            int count = 0;

            for (int i = 0; i < emailAddress.length(); i++) {
                //-------If Email address contains . character
                if (emailAddress.charAt(i) == '.') {
                    count++;
                    //-------If Email address contains more than one . character
                    if (emailAddress.charAt(i) == emailAddress.charAt(i + 1)) {
                        log.info("Email address contains consecutive .(dot) characters which is invalid");
                        count++;
                        break;
                    }
                }
            }
                if (count > 1) {
                    log.info("Email address contains more than .(dot) characters. Count: "+count);
                } else if (count == 1) {
                    log.info("Email Address contain one . (dot) character");
                } else {
                    log.info("Email address does not contain . (dot) character which is invalid");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validate_Email_Address_trailing_dot(String emailAddress) {
        try {
            //-------email address starting with . character
            if (emailAddress.startsWith(".")) {
                log.info("Email address is invalid as trailing dots are not allowed");
            } else {
                log.info("Email address does not start with .(dot) which is valid and as expected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validate_Email_Address_DomainNames(String emailAddress) {
        try {

            //-------The last portion of the domain must be at least two characters, for example: .com, .org, .cc
            if (emailAddress.length() >= 2) {
                if (emailAddress.endsWith(".com") || emailAddress.endsWith(".org") || emailAddress.endsWith(".cc")) {
                    log.info("The last portion of the email domain contains atleast two characters which is valid and as Expected");
                    log.info("Email domain is valid and as Expected");
                } else {
                    log.info("The last portion of the email domain does not end with expected domain names hence invalid data");
                }
            } else {
                log.info("The email address does not contain two characters hence invalid data");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validate_Email_Address_format(String emailAddress) {
        try {
            //-------Allowed characters: letters, numbers, dashes, dot.
            //------- The prefix appears to the left of the @ symbol.
            //------- The domain appears to the right of the @ symbol.

            //Regular Expression
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

            //Compile regular expression to get the pattern
            Pattern pattern = Pattern.compile(regex);

            String email = null;

            //Create instance of matcher
            Matcher matcher = pattern.matcher(email);
            System.out.println(email + " : " + matcher.matches() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Country Code validation on Contact Us page
     *
     * @param countryCode
     */
    public void validate_Country_Code_Length(String countryCode) {
        try {
            //-------country code length can be between 0 and 60
            if (countryCode.length() > 0 && countryCode.length() <= 60) {
                log.info("Country Code is valid and selectable as value by Country Code field ");
            } else {
                log.info("Country Code is larger than > 60 which is not expected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Phone validation on Contact Us page
     *
     * @param Phone
     */
    public void Validates_Phone_Alphabets(String Phone) {
        try {
            if (Phone.matches("[a-zA-Z]+") == true) {
                log.info("Full Name contains Alphabhets");
            } else {
                log.info("Full name does not contain Alphabhets");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Validates_Phone_SpecialChars(String Phone) {
        try {
            String str[] = Phone.split("");

            int count = 0;
            for (int i = 0; i < str.length; i++) {
                if (specialCharacters.contains(str[i])) {
                    count++;
                }
            }
            if (Phone != null && count == 0) {
                log.info("Valid phone number is entered");
            } else {
                log.info("Invalid phone number is entered");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Validates_Phone_length(String Phone) {
        try {
            if (Phone.length() != 10) {
                log.info("Invalid Phone Number");
            } else {
                log.info("Valid Phone Number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Message validation on Contact Us page
     *
     * @param Message
     */
    public void validate_Message_length(String Message) {
        try {
            //-------Acceptable characters in Message field>=500
            if (Message.length() <= 500) {
                log.info("Message is valid and acceptable as expected");
            } else {
                log.info("Message is not acceptable due to number of characters>500");
                log.info("Message WebElement trims extra length and accepts the input value");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void validate_Message_Input(String Message) {
        try {
            //-------Null or Empty values in Message textbox
            if (Message.trim().isEmpty() || Message == null) {
                log.info("Message is not entered by user");
            } else {
                log.info("Message is entered as expected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
