Feature: Validate UniCreds Contact-Us "Fill in your Information" Form

  @QATest
  Scenario Outline: Validate Name, Phone Number, Email & Loan Amount field for alphabets, alphanumeric, special characters on UniCreds Contact-Us "Fill in your Information" page
    Given User can launch browser
    When User opens UniCreds Contact-Us URL
    And User wait for Fill in your Information form to appear
    And User enters Name as <name> and Phone Number as <phoneNumber> and Email as <email>
    And User enters Loan Amount as <loanAmount> and selects Country of Study as <countryofStudy>
    And User selects Appointment Date as <appointmentDate> and Appointment Time as <appointmentTime>
    Then User clicks on Get OTP button and validates <name>, <phoneNumber>, <email>
    And User closes Fill in your Information form
    Examples:
      | name       | phoneNumber | email                      | loanAmount | countryofStudy | appointmentDate | appointmentTime |
      | Ayushi     | 9999999999  | ayu.mehta@gmail.com        | 1001       | Australia      | 12/17/2021      | 09 : 00  A.M.   |
      | Sa1ga9r    | 99999999990 | 0aYu-shi.Mehta@0gm-ail.com | 99         | United States  | 12/16/2021      | 06 : 30  P.M.   |
      | Jay#shr@ee | 999999999   | .ayu.mehta@gmail.c         | 1000       | India          | 12/15/2021      | 10 : 00  A.M.   |
      | Vivek      | +9999999e9  | _______@example.com        | 1000000    | Australia      | 12/17/2021      | 05 : 30  A.M.   |


  @QATest
  Scenario Outline: Validate Loan Amount and Country of Study field on UniCreds Contact-Us "Fill in your Information" page
    Given User can launch browser
    When User opens UniCreds Contact-Us URL
    And User wait for Fill in your Information form to appear
    And User enters Name as <name> and Phone Number as <phoneNumber> and Email as <email>
    And User enters Loan Amount as <loanAmount> and selects Country of Study as <countryofStudy>
    And User selects Appointment Date as <appointmentDate> and Appointment Time as <appointmentTime>
    Then User clicks on Get OTP button and validates <loanAmount> and <countryofStudy> field
    And User closes Fill in your Information form
    Examples:
      | name    | phoneNumber | email               | loanAmount | countryofStudy | appointmentDate | appointmentTime |
      | Vivek   | 9999999999  | ayu.mehta@gmail.com | 99         | Australia      | 12/17/2021      | 05 : 30  A.M.   |
      | Sushant | 9999999999  | ayu.mehta@gmail.com | 1001       | Australia      | 12/17/2021      | 07 : 00  A.M.   |
      | Suraj   | 9999999999  | ayu.mehta@gmail.com | 100000000  | India          | 12/17/2021      | 06 : 30  P.M.   |
      | Ayushi  | 9999999999  | ayu.mehta@gmail.com | 99999999   | Australia      | 12/17/2021      | 09 : 00  A.M.   |
      | Sa1ga9r | 99999999990 | ayu.mehtagmail.com  | 9999999    | United States  | 12/16/2021      | 06 : 30  P.M.   |


  @QATest
  Scenario Outline: Validate Appointment Date, Appointment Time field on UniCreds Contact-Us "Fill in your Information" page
    Given User can launch browser
    When User opens UniCreds Contact-Us URL
    And User wait for Fill in your Information form to appear
    And User enters Name as <name> and Phone Number as <phoneNumber> and Email as <email>
    And User enters Loan Amount as <loanAmount> and selects Country of Study as <countryofStudy>
    And User selects Appointment Date as <appointmentDate> and Appointment Time as <appointmentTime>
    Then User clicks on Get OTP button then validates <appointmentDate> and <appointmentTime>
    And User closes Fill in your Information form
    Examples:
      | name    | phoneNumber | email               | loanAmount | countryofStudy | appointmentDate | appointmentTime |
      | Vivek   | 9999999999  | ayu.mehta@gmail.com | 999        | Australia      | 12/11/2021      | 05 : 30  P.M.   |
      | Sushant | 9999999999  | ayu.mehta@gmail.com | 1001       | Australia      | 13/12/2021      | 07 : 00         |
      | Suraj   | 9999999999  | ayu.mehta@gmail.com | 1000       | India          | 12/17/2022      | 06 : 30  A.M.   |


