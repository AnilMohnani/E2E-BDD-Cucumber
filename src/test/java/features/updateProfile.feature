Feature: Update My Profile

  Background: Flow till User Logged in successfully
    Given User is on the Bank Home Page

  Scenario Outline: Update Region field in My Profile
    When User clicks on Image icon on RHS of home page
    When A drop down appears and User selects My Profile
    Then User lands on My Profile screen
    Then User scrolls the screen till region
    And User updates region "<Region>"
    When User clicks submit
    Then Profile is updated successfully and message "<Message>" on the screen
    Examples:
      | Region     | Message |
      | Thane East | Success |
