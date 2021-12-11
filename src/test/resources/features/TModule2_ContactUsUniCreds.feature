Feature: Validate UniCreds Contact-Us Page


  Scenario: Validate Presence of expected fields and Mandatory fields on UniCreds Contact-Us page
    Given User can launch browser
    When User opens UniCreds Contact-Us URL
    And User wait for Fill in your Information form to appear
    And User closes Fill in your Information form
    And User validates presence of Full Name, Email Address, Country Code, Phone and Message fields
    Then User performs Mandatory field validation


  Scenario Outline: Validate Full Name field for length, alphabets, alphanumeric, special characters on UniCreds Contact-Us page
    Given User can launch browser
    When User opens UniCreds Contact-Us URL
    And User wait for Fill in your Information form to appear
    And User closes Fill in your Information form
    And User enters value in Full Name <fullName>
    And User enters Email Address <emailAddress>
    And User selects Country Code <countryCode>
    And User enters value in Phone <phone>
    And User enter Message <message>
    Then User clicks on Submit button
    And User validates Full Name <fullName> field
    And User validates if success message appears <successMessage>
    Examples:
      | fullName                                              | emailAddress              | countryCode | phone      | message                           | successMessage             |
      | Ayushi Mehta                                          | ayushi.mehta115@gmail.com | India (+91) | 0101010101 | Hi, I am running Automation Tests | Message sent successfully! |
      | erre23434&*&&! 1_-+                                   | ayushi.mehta115@gmail.com | India (+91) | 0101010101 | Hi, I am running Automation Tests | Message sent successfully! |
      | Hubert Blaine Wolfeschlegelsteinhausenbergerdorff Sr. | ayushi.mehta115@gmail.com | India (+91) | 0101010101 | Hi, I am running Automation Tests | Message sent successfully! |

  @QAContactTest
  Scenario Outline: Validate Email Address field for length, alphabets, alphanumeric, special characters on UniCreds Contact-Us page
    Given User can launch browser
    When User opens UniCreds Contact-Us URL
    And User wait for Fill in your Information form to appear
    And User closes Fill in your Information form
    And User enters value in Full Name <fullName>
    And User enters Email Address <emailAddress>
    And User selects Country Code <countryCode>
    And User enters value in Phone <phone>
    And User enter Message <message>
    Then User clicks on Submit button
    And User validates Email Address <emailAddress> field
    And User validates if success message appears <successMessage>
    Examples:
      | fullName     | emailAddress                                         | countryCode | phone      | message                           | successMessage             |
      | Ayushi Mehta | .firstname+lastname+middlename@subdomain.example.com | India (+91) | 0101010101 | Hi, I am running Automation Tests | Message sent successfully! |
      | Ayushi Mehta | example..first@mail@trap.io.                         | India (+91) | 0101010101 | Hi, I am running Automation Tests | Message sent successfully! |
      | Ayushi Mehta | 0aYu-shi.Mehta@0gm-ail.com                           | India (+91) | 0101010101 | Hi, I am running Automation Tests | Message sent successfully! |
      | Ayushi Mehta | test                                                 | India (+91) | 0101010101 | Hi, I am running Automation Tests | Message sent successfully! |

  @QAContactTest
  Scenario Outline: Validate Country Code field alphabets, alphanumeric, special characters on UniCreds Contact-Us page
    Given User can launch browser
    When User opens UniCreds Contact-Us URL
    And User wait for Fill in your Information form to appear
    And User closes Fill in your Information form
    And User enters value in Full Name <fullName>
    And User enters Email Address <emailAddress>
    And User selects Country Code <countryCode>
    And User enters value in Phone <phone>
    And User enter Message <message>
    Then User clicks on Submit button
    And User validates Country Code <countryCode>
    And User validates if success message appears <successMessage>
    Examples:
      | fullName     | emailAddress              | countryCode                                             | phone      | message                           | successMessage             |
      | Ayushi Mehta | ayushi.mehta115@gmail.com | India (+91)                                             | 0101010101 | Hi, I am running Automation Tests | Message sent successfully! |
      | Ayushi Mehta | ayushi.mehta115@gmail.com | Virgin Islands - US (+1340)                             | 0101010101 | Hi, I am running Automation Tests | Message sent successfully! |
      | Ayushi Mehta | ayushi.mehta115@gmail.com | testing left Turks & Caicos Islands (+1649342532443234) | 0101010101 | Hi, I am running Automation Tests | Message sent successfully! |

  @QAContactTest
  Scenario Outline: Validate Phone field for length, alphabets, alphanumeric, special characters on UniCreds Contact-Us page
    Given User can launch browser
    When User opens UniCreds Contact-Us URL
    And User wait for Fill in your Information form to appear
    And User closes Fill in your Information form
    And User enters value in Full Name <fullName>
    And User enters Email Address <emailAddress>
    And User selects Country Code <countryCode>
    And User enters value in Phone <phone>
    And User enter Message <message>
    Then User clicks on Submit button
    And User validates Phone <phone> field
    And User validates if success message appears <successMessage>
    Examples:
      | fullName     | emailAddress              | countryCode | phone        | message                           | successMessage             |
      | Ayushi Mehta | ayushi.mehta115@gmail.com | India (+91) | 0101010101   | Hi, I am running Automation Tests | Message sent successfully! |
      | Ayushi Mehta | ayushi.mehta115@gmail.com | India (+91) | 01@10Ab01-21 | Hi, I am running Automation Tests | Message sent successfully! |
      | Ayushi Mehta | ayushi.mehta115@gmail.com | India (+91) | 01101021     | Hi, I am running Automation Tests | Message sent successfully! |

  @QAContactTest
  Scenario Outline: Validate Message field for length, alphabets, alphanumeric, special characters on UniCreds Contact-Us page
    Given User can launch browser
    When User opens UniCreds Contact-Us URL
    And User wait for Fill in your Information form to appear
    And User closes Fill in your Information form
    And User enters value in Full Name <fullName>
    And User enters Email Address <emailAddress>
    And User selects Country Code <countryCode>
    And User enters value in Phone <phone>
    And User enter Message <message>
    Then User clicks on Submit button
    And User validates Message <message> field
    And User validates if success message appears <successMessage>
    Examples:
      | fullName     | emailAddress              | countryCode | phone      | message                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | successMessage             |
      | Ayushi Mehta | ayushi.mehta115@gmail.com | India (+91) | 0101010101 | testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-test      | Message sent successfully! |
      | Ayushi Mehta | ayushi.mehta115@gmail.com | India (+91) | 0101010101 | test-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-testmessage12@0-test | Message sent successfully! |