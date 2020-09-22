Feature: Bank Transactions

	 Background: 
	 Given User has logged successfully into the Application
	 @Smoke
	 Scenario Outline: Withdraw Amount
    When User clicks on transactions menu on LHS panel of home page
    And Selects Withdraw Amount option
    When User lands on Withdraw Amount Screen
    And Selects the account for transaction by entering "<value>"
    When User Enters Amount "<Amount>" for withdrawl
    And User clicks on submit button
    Then Transaction is successful and User lands on Views Savings Screen and Sees Last Transaction "<amountDeducted>"

    Examples: 
     |value | Amount  |amountDeducted|
     | 26854|   1			|				$-1.00 |
     
  @Smoke
	Scenario Outline: Deposit Amount
	
    When User clicks on transactions menu on LHS panel of home page
    And Selects Deposit Amount option
    When User lands on Deposit Amount Screen
    And Selects the account for deposit by entering "<value>"
    When User Enters Amount "<Amount>" for deposit
    And User clicks on submit button in Amount Deposit Screen
    Then Transaction is successful and User lands on Views Savings Screen and Sees Last Deposit Transaction "<amountDeposited>"
    
      Examples: 
     |value | Amount  |amountDeposited  |
     | 26854|   5		  |				$5.00			|
    
	