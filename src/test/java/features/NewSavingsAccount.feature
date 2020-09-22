Feature: Savings Account
  
 Background: Flow till User Logged in successfully
  Given User is on the Bank Home Page after successful login
	@Smoke
  Scenario Outline: Create New Savings Account
    Given User clicks on savings dropdown menu
    And chooses New Savings from the menu
    Then User lands on New Account Savings Creation Page
    When User chooses Account Type from one of two radio buttons
    And User chooses Account Ownership type from one of two radio buttons
    And User enters Account name "<accountName>" which should be short and descriptive
    And User enters Intial deposit "<intialDepositAmt>" which should be more than 25
    Then User clicks on submit buttomn
    And User lands on View Savings screen and sees his "<accountName>" Active 
    

   Examples:
   
    |accountName|intialDepositAmt|
    |		Mayank	|	60						 |