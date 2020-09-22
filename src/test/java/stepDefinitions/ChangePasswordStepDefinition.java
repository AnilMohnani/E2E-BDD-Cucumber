package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.pageObjects.ChangePasswordPage;
import com.cucumberFramework.pageObjects.MyHomeBankPage;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangePasswordStepDefinition extends TestBase {
	private static final org.apache.logging.log4j.Logger log = LoggerHelper
			.getLogger(ChangePasswordStepDefinition.class);
	MyHomeBankPage mhbp;
	ChangePasswordPage cpp;

	@Given("User is on Bank Home Page")
	public void user_is_on_bank_home_page() throws IOException {
		mhbp = ResusableFunctions.login();
		log.info("Login successful");

	}

	@When("User clicks on Image icon on top right corner")
	public void user_clicks_on_image_icon_on_top_right_corner() {
		mhbp.clickImageIcon();
		log.debug("Image icon clicked successfully");
	}

	@When("User Selects Change Password option")
	public void user_selects_change_password_option() {
		cpp = mhbp.clickChangePasswordLink();
		log.debug("Change password link clicked successfully");

	}

	@Then("User lands on Change Password section")
	public void user_lands_on_change_password_section() {

		log.info("User lands on Change Password Section");

	}

	@Then("User enters CurrentPassword {string}")
	public void user_enters_current_password(String currentPasswordData) {
		cpp.enterCurentPassword(currentPasswordData);
		log.debug("User entered current Password");
	}

	@When("User enters NewPassword {string}")
	public void user_enters_new_password(String newPasswordData) {
		cpp.enterNewPassword(newPasswordData);
		log.debug("User entered new Password");

	}

	@When("User enters his Password again {string}")
	public void user_enters_his_password_again(String confirmPasswordData) {
		cpp.enterConfirmPassword(confirmPasswordData);
		log.debug("User entered confirmed Password");

	}

	@When("User clicks update Password button")
	public void user_clicks_update_Password_button() {
		cpp.clickUpdatePassswordBtn();
		log.debug("User clicks update password button");
	}

	@Then("Password changed successfully and Success {string} is seen on the screen")
	public void password_changed_successfully_and_success_is_seen_on_the_screen(String sucessMsg) {
		Assert.assertEquals(cpp.getUpdatePasswordSuccess(), sucessMsg);
		log.info("Successfully Updated Password");
	}

	@Then("User enters wrongCurrentPassword {string}")
	public void user_enters_wrong_current_password(String wrongCurrentPassword) {
		cpp.enterCurentPassword(wrongCurrentPassword);
		log.debug("Wrong Password entered");
	}

	@Then("User sees error message {string} on the screen")
	public void user_sees_error_message_on_the_screen(String errorMsg) {
		Assert.assertEquals(errorMsg, cpp.getIncorrectPasswordErrorMsg());
		log.info("Incorrect Current Password");

	}
}