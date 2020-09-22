
package stepDefinitions;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import com.cucumberFramework.helper.ExcelHelper;
import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.pageObjects.BankLoginPage;
import com.cucumberFramework.pageObjects.BankRegistrationPage1;
import com.cucumberFramework.pageObjects.BankRegistrationPage2;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankRegistrationStepDefinition extends TestBase {
	ExcelHelper excelHelper=new ExcelHelper();
	HashMap<String,String> map=ExcelHelper.getExcelData(testDataPath,"registerData");
	BankRegistrationPage1 brp1;
	BankRegistrationPage2 brp2;
	BankLoginPage lp;
	private static final org.apache.logging.log4j.Logger log = LoggerHelper.getLogger(BankRegistrationStepDefinition.class);

	
	@Given("User is on Bank Registration Page")
	public void user_is_on_bank_registration_page() {
		lp=new BankLoginPage(driver);
		brp1=lp.navigateToSignupPage();
		log.info("User is on Bank Login Page");
	}

	@When("User selects title option from title dropdown entered in excel")
	public void User_selects_title_option_from_title_dropdown_entered_in_excel() {
	brp1.selectTitle(map.get("title")); 
	log.debug("User selected title successfully");
	}

	@When("User enters his first name through excel")
	public void user_enters_his_first_name_through_excel() {
	    brp1.enterFirstname(map.get("firstName"));
		log.debug("User entered first name successfully");

	}

	@When("User enters his last name through excel")
	public void user_enters_his_last_name_through_excel() {
	   brp1.enterLastname(map.get("lastName"));
		log.debug("User entered last name successfully");

	}

	@When("User selects his gender")
	public void user_selects_his_gender() {
	brp1.selectGender();
	log.debug("User selected gender successfully");

	}

	@When("User enters his date of birth in MM\\/DD\\/YYYT format through excel")
	public void user_enters_his_date_of_birth_in_mm_dd_yyyt_format_through_excel() {
	    brp1.enterDOB(map.get("dob"));
		log.debug("User entered dob successfully");

	}

	@When("User enters his unique SSN number in XXX-XX-XXXX format through excel")
	public void user_enters_his_unique_ssn_number_in_xxx_xx_xxxx_format_through_excel() {
	    brp1.enterSSN(map.get("ssn"));
		log.debug("User entered ssn successfully");

	}

	@When("User enters his email address through excel")
	public void user_enters_his_email_address_through_excel() {
	    brp1.enterEmail(map.get("email"));
		log.debug("User entered email successfully");

	}

	@When("User enters his password of minimum {int} characters containing uppercase,lowercase characters and digits through excel")
	public void user_enters_his_password_of_minimum_characters_containing_uppercase_lowercase_characters_and_digits_through_excel(Integer int1) {
	   brp1.enterPassword(map.get("password"));
		log.debug("User entered password successfully");

	}

	@When("User enters his samePassword again in confirmation field through excel")
	public void user_enters_his_same_password_again_in_confirmation_field_through_excel() {
	 brp1.enterCnfPassword(map.get("confPassword"));
		log.debug("User enters his password again successfully");

	}

	@When("User click on Next buttons")
	public void user_click_on_next_buttons() {
		brp2=brp1.clickNext();
		log.debug("User clicked on Next button successfully");

	}

	@Then("User lands on Registration Page2")
	public void user_lands_on_registration_page() {
		log.info("User lands on Bank registration Page 2");
	   System.out.println("Page 2 process");
	   System.out.println(driver.findElement(By.xpath("//strong[contains(text(),'Address')]")).getText());

	}

	@When("User enters his address through excel")
	public void user_enters_his_address_through_excel() throws InterruptedException {
	brp2.enterAddress(map.get("address"));
	log.debug("User entered his address successfully");

	}

	@When("User enters his locality through excel")
	public void user_enters_his_locality_through_excel() {
	    brp2.enterLocality(map.get("locality"));
		log.debug("User entered his locality successfully");

	}

	@When("User enters his region through excel")
	public void user_enters_his_region_through_excel() {
	    brp2.enterRegion(map.get("region"));
		log.debug("User entered his region successfully");

	}

	@When("User enters his valid zipcode through excel")
	public void user_enters_his_valid_zipcode_through_excel() {
	    brp2.enterZipcode(map.get("zipcode"));
		log.debug("User entered his zipcode successfully");

	}

	@When("User enters his country Name through excel")
	public void user_enters_his_country_name_through_excel() {
	    brp2.enterCountry(map.get("country"));
		log.debug("User entered his country successfully");

	}

	@When("User enters his homePhoneNumber through excel")
	public void user_enters_his_home_phone_number_through_excel() {
	    brp2.enterHomePhone(map.get("homeNo"));
		log.debug("User entered his home phone number successfully");

	}

	@When("User enters his mobilePhoneNumber through excel")
	public void user_enters_his_mobile_phone_number_through_excel() {
	   brp2.enterMobilePhone(map.get("mobNo"));
		log.debug("User entered his Mobile No successfully");

	}

	@When("User enters his workPhoneNumber through excel")
	public void user_enters_his_work_phone_number_through_excel() {
	   brp2.enterWorkPhone(map.get("workNo"));
		log.debug("User entered his Work No successfully");

	}

	@When("User Checks the terms & conditions checkbox")
	public void user_checks_the_terms_conditions_checkbox() {
	  brp2.clickAgree();
		log.debug("User checked terms and conditions checkbox successfully");

	}

	@When("User click on Register Button")
	public void user_click_on_register_button() {
	   brp2.clickRegisterButton();
		log.debug("User clicked register button successfully");

	}

	@Then("User lands on the login screen with registrationSuccessMessage")
	public void user_lands_on_the_login_screen_with_registration_success_message() {
	    String successTxt=lp.getRegistrationSuccess();
	   Assert.assertEquals(map.get("successValidation"), successTxt);
		log.debug("User registers successfully and lands on login screen");

	}

}
