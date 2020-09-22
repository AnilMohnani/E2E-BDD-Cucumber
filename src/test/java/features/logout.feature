Feature: Logout Feature

	@Smoke
  Scenario: Logout Functionality
    Given User is logged in successfully and is in Home Page.
    When User clicks on image link on RHS side of Home Page.
    And clicks on Logout link from the menu 
    Then Logout is successful and user lands on Login screen.
   	|   Success |

   
