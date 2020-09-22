Feature: Login functionality of Bank Application
	@Smoke
  Scenario Outline: Login with valid credentials
    Given User is on Bank Login Screen
    When User Enters Valid "<Username>" and Valid "<Password>"
    And User Clicks Sign In Button
    Then User Should land on Account Home Screen with "<Welcome>" Message

    Examples: 
      | Username          | Password | Welcome      |
      | anil101@gmail.com | Anil99$$ | Welcome Anil |

  Scenario Outline: Validate error message on invalid login credentials
    Given User is on Bank Login Screen
    When User Enters valid "<Username>" and Invalid "<invalidPassword>"
    And User Clicks Sign In Button
    Then User should see "<Error>" Message on the login screen

    Examples: 
      | Username          | invalidPassword | Error                                      |
      | anil101@gmail.com |            1234 | Invalid credentials or access not granted. |
