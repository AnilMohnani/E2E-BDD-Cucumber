package stepDefinitions;

import java.util.List;

import org.junit.Assert;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.pageObjects.BankLoginPage;
import com.cucumberFramework.pageObjects.MyHomeBankPage;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDefinition extends TestBase{
	private static final org.apache.logging.log4j.Logger log = LoggerHelper.getLogger(LogoutStepDefinition.class);

	MyHomeBankPage mhbp;
	BankLoginPage blp;
	@Given("User is logged in successfully and is in Home Page.")
	public void user_is_logged_in_successfully_and_is_in_home_page() {
		mhbp=ResusableFunctions.newlogin();
		log.info("Login is successful.");
	}



	@When("User clicks on image link on RHS side of Home Page.")
	public void user_clicks_on_image_link_on_rhs_side_of_home_page() {
		
		mhbp.clickImageIcon();
		log.debug("Image icon clicked successfully");
	}
	@When("clicks on Logout link from the menu")
	public void clicks_on_logout_link_from_the_menu() {
	   blp=mhbp.clickLogout();
	   log.debug("Logout link clicked successfully.");
	}
	@Then("Logout is successful and user lands on Login screen.")
	public void logout_is_successful_and_user_lands_on_login_screen(io.cucumber.datatable.DataTable dataTable) {
	    List<String> list=dataTable.asList();
	    Assert.assertEquals(list.get(0).toString(), blp.getLogoutSuccessValidator());
	    log.info("Log out successful.");
	}



}
