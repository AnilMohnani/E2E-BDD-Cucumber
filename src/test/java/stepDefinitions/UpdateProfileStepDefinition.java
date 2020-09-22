package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.pageObjects.MyHomeBankPage;
import com.cucumberFramework.pageObjects.MyProfilePage;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateProfileStepDefinition extends TestBase{
	private static final org.apache.logging.log4j.Logger log = LoggerHelper
			.getLogger(UpdateProfileStepDefinition.class);
	MyHomeBankPage mhbp;
	MyProfilePage mpl;
	@Given("User is on the Bank Home Page")
	public void user_is_on_the_bank_home_page() throws IOException {
		mhbp=ResusableFunctions.newlogin();
		log.info("User is on home page");

	}
	
	@When("User clicks on Image icon on RHS of home page")
	public void user_clicks_on_image_icon_on_rhs_of_home_page() {
	mhbp.clickImageIcon();
	}

	@When("A drop down appears and User selects My Profile")
	public void a_drop_down_appears_and_user_selects_my_profile() {
	  mpl= mhbp.clickMyProfileLink();
	}

	@Then("User lands on My Profile screen")
	public void user_lands_on_my_profile_screen() {
		log.info("User is on my profile screen");
		
	}
	@Then("User scrolls the screen till region")
	public void user_scrolls_the_screen_till_region() {
		mpl.scrollTillElement();
	}

	@Then("User updates region {string}")
	public void user_updates_region(String newRegionData) {
	  mpl.deletePreviousRegionData();
	  mpl.enterNewRegionData(newRegionData);
	}

	@When("User clicks submit")
	public void user_clicks_submit() {
	   mpl.clickSubmit();
	}

	@Then("Profile is updated successfully and message {string} on the screen")
	public void profile_is_updated_successfully_and_message_on_the_screen(String success) {
	    Assert.assertEquals(success, mpl.getSuccessMessage());
		
	}

}
