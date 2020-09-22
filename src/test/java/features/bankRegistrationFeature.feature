Feature: Resistration of a new user in the Bank

  Scenario: User Registration
    Given User is on Bank Registration Page
    When User selects title option from title dropdown entered in excel
    And User enters his first name through excel
    And User enters his last name through excel
    And User selects his gender
    And User enters his date of birth in MM/DD/YYYT format through excel
    And User enters his unique SSN number in XXX-XX-XXXX format through excel
    And User enters his email address through excel
    And User enters his password of minimum 8 characters containing uppercase,lowercase characters and digits through excel
    And User enters his samePassword again in confirmation field through excel
    And User click on Next buttons
    Then User lands on Registration Page2
    And User enters his address through excel
    And User enters his locality through excel
    And User enters his region through excel
    And User enters his valid zipcode through excel
    And User enters his country Name through excel
    And User enters his homePhoneNumber through excel
    And User enters his mobilePhoneNumber through excel
    And User enters his workPhoneNumber through excel
    And User Checks the terms & conditions checkbox
    And User click on Register Button
    Then User lands on the login screen with registrationSuccessMessage
