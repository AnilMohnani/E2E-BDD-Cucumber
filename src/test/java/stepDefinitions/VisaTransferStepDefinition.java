package stepDefinitions;

import org.junit.Assert;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.pageObjects.MyHomeBankPage;
import com.cucumberFramework.pageObjects.VisaDirectPaymentResponsePage;
import com.cucumberFramework.pageObjects.VisaTransferPage;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VisaTransferStepDefinition extends TestBase {
	private static final org.apache.logging.log4j.Logger log = LoggerHelper.getLogger(VisaTransferStepDefinition.class);

	MyHomeBankPage mhbp;
	VisaTransferPage vtp;
	VisaDirectPaymentResponsePage vsprp;
	
	
	@Given("User has logged successfully with valid credentials.")
	public void user_has_logged_successfully_with_valid_credentials() {
	    mhbp=ResusableFunctions.newlogin();
	    log.info("Login Successful.");
	    
	}
	
	@When("User clicks on Visa Direct Link on LHS panel.")
	public void user_clicks_on_visa_direct_link_on_lhs_panel() {
		mhbp.clickVisaDirectLink();
		log.debug("Visa Direct Link clicked Successfully.");
	}
	@When("User Clicks on Visa Transfer Link.")
	public void user_clicks_on_visa_transfer_link() {
	   vtp=mhbp.clickVisaTransferLink();
		log.debug("Visa Transfer Link clicked Successfully.");

	}
	@Given("User selects a transfer account from the dropdown {string}.")
	public void user_selects_a_transfer_account_from_the_dropdown(String value) {
	    vtp.selectVisaAccount(value);
		log.debug("Account selected Successfully.");

	}
	@Given("User enters the amount {string} in the field")
	public void user_enters_the_amount_in_the_field(String data) {
	   vtp.enterVisaAmount(data);
		log.debug("Visa amount entered for transfer.");

	}
	@When("User clicks the Submit button successfully.")
	public void user_clicks_the_submit_button_successfully() {
		vsprp= vtp.clickVisaTransferScreenSubmit();
		log.debug("Submit button clicked successfully.s");
	}
	@Then("User lands on success screen and sees the Success Message {string}")
	public void user_lands_on_success_screen_and_sees_the_success_message(String expected) {
	   String actual= vsprp.getverificationVisaPaymentSuccess();
	   Assert.assertEquals(expected, actual);
	   log.info("Visa Payment successful.");
	}



}
