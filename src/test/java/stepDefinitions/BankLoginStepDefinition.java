package stepDefinitions;

import org.junit.Assert;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.pageObjects.BankLoginPage;
import com.cucumberFramework.pageObjects.MyHomeBankPage;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankLoginStepDefinition extends TestBase {
	private static final org.apache.logging.log4j.Logger log = LoggerHelper.getLogger(BankLoginStepDefinition.class);

	BankLoginPage lp;
	MyHomeBankPage hbp;

	@Given("User is on Bank Login Screen")
	public void user_is_on_bank_login_screen() {
		lp = new BankLoginPage(driver);
	}

	@When("User Enters Valid {string} and Valid {string}")
	public void user_enters_valid_and_valid(String username, String password) {
		lp.enterUsername(username);
		log.debug("Valid Username entered successfully");
		lp.enterPassword(password);
		log.debug("Valid Password entered successfully");

	}

	@And("User Clicks Sign In Button")
	public void user_clicks_sign_in_button() {
		hbp = lp.signInButtonClick();
		log.debug("Sign in button clicked successfully");
	}

	@Then("User Should land on Account Home Screen with {string} Message")
	public void user_should_see_message_on_account_home_screen(String textMessage) {

		String actualMessage = hbp.getWelcomeText();
		Assert.assertEquals(textMessage, actualMessage);
		log.info("Login Success");
	}

	@When("User Enters valid {string} and Invalid {string}")
	public void user_enters_valid_and_invalid(String validUsername, String invalidPassword) {
		lp.enterUsername(validUsername);
		log.debug("Valid Username entered successfully");
		lp.enterPassword(invalidPassword);
		log.debug("Invalid Password entered successfully");


	}

	@Then("User should see {string} Message on the login screen")
	public void user_should_see_message_on_the_login_screen(String expectedLoginMessage) {
		String actualLoginErrorMessage = lp.getLoginErrorMessage();
		Assert.assertEquals(expectedLoginMessage, actualLoginErrorMessage);
		log.info("Invalid Login");
	}

}
