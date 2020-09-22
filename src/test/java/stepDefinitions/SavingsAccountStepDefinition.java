package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.pageObjects.MyHomeBankPage;
import com.cucumberFramework.pageObjects.NewSavingsAccountPage;
import com.cucumberFramework.pageObjects.ViewSavingsPage;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SavingsAccountStepDefinition extends TestBase {
	private static final org.apache.logging.log4j.Logger log = LoggerHelper
			.getLogger(SavingsAccountStepDefinition.class);
	
	MyHomeBankPage mhbp;
	NewSavingsAccountPage nsap;
	ViewSavingsPage vsp;
	
	@Given("User is on the Bank Home Page after successful login")
	public void user_is_on_the_bank_home_page() throws IOException {
		mhbp=ResusableFunctions.newlogin();
		log.info("User is on home page");
	}
	
	
	@Given("User clicks on savings dropdown menu")
	public void user_clicks_on_savings_dropdown_menu() {

		mhbp.clickSavingsMenu();
		log.debug("Savings drop down clicked successfully.");
	}

	@Given("chooses New Savings from the menu")
	public void chooses_new_savings_from_the_menu() {
		 nsap=mhbp.clickNewSavingsAccount();
		log.debug("New Savings Account clicked successfully.");
	   
	}
	@Then("User lands on New Account Savings Creation Page")
	public void user_lands_on_new_account_savings_creation_page() {
		 log.info("User lands on Account Ceation Page");
	}
	@When("User chooses Account Type from one of two radio buttons")
	public void user_chooses_account_type_from_one_of_two_radio_buttons() {
		nsap.chooseSavins();
	    log.debug("Savings Account Selected");
	   
	}
	@When("User chooses Account Ownership type from one of two radio buttons")
	public void user_chooses_account_ownership_type_from_one_of_two_radio_buttons() {
	   nsap.chooseIndividual();
	    log.debug("Individual Ownership Selected");

	}
	@When("User enters Account name {string} which should be short and descriptive")
	public void user_enters_account_name_which_should_be_short_and_descriptive(String accountNameData) {
		nsap.enterAccountName(accountNameData);
		log.debug("Account Name Entered");
	}
	@When("User enters Intial deposit {string} which should be more than 25")
	public void user_enters_intial_deposit_which_should_be_more_than_25$(String initialDepositAmt) {
	    nsap.enterInitialDeposit(initialDepositAmt);
		log.debug("Initial Deposit Amount Entered");

	}
	@Then("User clicks on submit buttomn")
	public void user_clicks_on_submit_buttomn() {
	    vsp=nsap.submitNewSavingsAccountCreation();
		log.debug("Submit button clicked");

	}

	@Then("User lands on View Savings screen and sees his {string} Active")
	public void user_lands_on_view_savings_screen_and_sees_his_active(String accountName) {
	    Assert.assertEquals(accountName, vsp.getActiveAccountName());
	}



}
