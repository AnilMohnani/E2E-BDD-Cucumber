Feature: VISA Transfer Functionality

  Background: 
    Given User has logged successfully with valid credentials.
    When User clicks on Visa Direct Link on LHS panel.
    When User Clicks on Visa Transfer Link.

  Scenario Outline: VISA Transfer successful.
    Given User selects a transfer account from the dropdown "<accountValue>".
    And User enters the amount "<amount>" in the field
    When User clicks the Submit button successfully.
    Then User lands on success screen and sees the Success Message "<message>"

    Examples: 
      | accountValue    | amount | message                    |
      | ABCD1234ABCD123 |      3 | Approval Status = Approved |
