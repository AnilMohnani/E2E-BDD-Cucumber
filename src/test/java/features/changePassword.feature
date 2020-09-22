Feature: Change Password

  Background: 
  Given User is on Bank Home Page
  
   Scenario Outline: New and Confirmed Password does not match while updating password
   	
   	When User clicks on Image icon on top right corner
    When User Selects Change Password option
    Then User lands on Change Password section
    But User enters wrongCurrentPassword "<wrongCurrentPassword>"
    When User enters NewPassword "<NewPassword>"
    And User enters his Password again "<ConfirmedPassword>"
    And User clicks update Password button 
    Then User sees error message "<errorMessage>" on the screen 

	Examples:
	
	|wrongCurrentPassword|NewPassword|ConfirmedPassword|errorMessage|
	|Sumit99$%^|Anil6746$$|Anil6746$$|Error|  
   	
    
		Scenario Outline: Change Password Functionaity
    When User clicks on Image icon on top right corner
    When User Selects Change Password option
    Then User lands on Change Password section
    And User enters CurrentPassword "<CurrentPassword>"
    When User enters NewPassword "<NewPassword>"
    When User enters his Password again "<ConfirmedPassword>"
    When User clicks update Password button 
    Then Password changed successfully and Success "<successMessage>" is seen on the screen
    
    
    Examples: 
    
      | CurrentPassword | NewPassword | ConfirmedPassword | successMessage |
      | Anil99$$        | Anil6746$$       | Anil6746$$   |Success 				 |
    
   
	