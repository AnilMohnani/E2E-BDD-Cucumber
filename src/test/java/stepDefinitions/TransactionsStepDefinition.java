package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.pageObjects.DepositAmountPage;
import com.cucumberFramework.pageObjects.MyHomeBankPage;
import com.cucumberFramework.pageObjects.ViewSavingsPage;
import com.cucumberFramework.pageObjects.WithdrawAmountPage;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransactionsStepDefinition extends TestBase {
	private static final org.apache.logging.log4j.Logger log = LoggerHelper.getLogger(TransactionsStepDefinition.class);

	MyHomeBankPage mhbp;
	WithdrawAmountPage wap;
	ViewSavingsPage vsp;
	DepositAmountPage dap;

	@Given("User has logged successfully into the Application")
	public void user_has_logged_successfully_into_the_application() {
		mhbp = ResusableFunctions.newlogin();
		log.info("Login successful");
	}

	@When("User clicks on transactions menu on LHS panel of home page")
	public void user_clicks_on_transactions_menu_on_lhs_panel_of_home_page() {
		mhbp.clickTransactionsLink();
		log.debug("Transactions menu clicked.");
	}

	@When("Selects Withdraw Amount option")
	public void selects_withdraw_amount_option() {
		wap = mhbp.clickWithdrawLink();
		log.debug("Withdraw amount option clicked.");
	}

	@When("User lands on Withdraw Amount Screen")
	public void user_lands_on_withdraw_amount_screen() {
		log.info("User lands on Withdraw amount Screen");

	}

	@When("Selects the account for transaction by entering {string}")
	public void selects_the_account_for_transaction_by_entering(String value) {
		wap.selectTestAccount(value);
		log.debug("Account Selected for withdraw.");

	}

	@When("User Enters Amount {string} for withdrawl")
	public void user_enters_amount_for_withdrawl(String amt) {
		wap.enterWithdrawalAmount(amt);
		log.debug("Amount Entered for withdraw.");
	}

	@When("User clicks on submit button")
	public void user_clicks_on_submit_button() {
		vsp = wap.submitBtnClick();
		log.debug("Submit button clicked");

	}

	@When("Selects Deposit Amount option")
	public void selects_deposit_amount_option() {
		dap = mhbp.clickDepositLink();
		log.debug("Deposit Amount option selected from transactions menu");
	}

	@When("User lands on Deposit Amount Screen")
	public void user_lands_on_deposit_amount_screen() {
		log.info("User lands on Deposit Account Screen");

	}

	@When("Selects the account for deposit by entering {string}")
	public void selects_the_account_for_deposit_by_entering(String value) {
		dap.selectTestAccountForDeoposit(value);
		log.debug("Account selected for deposit");
	}

	@When("User Enters Amount {string} for deposit")
	public void user_enters_amount_for_deposit(String data) {
		dap.enterDepositAmount(data);
		log.debug("Amount Entered for deposit");
	}
	
	@When("User clicks on submit button in Amount Deposit Screen")
	public void user_clicks_on_submit_button_in_amount_deposit_screen() {
	    vsp=dap.clickSubmitBtnAfterDeposotAmtEntered();
	    log.debug("Submit button clicked.");
	}


	@Then("Transaction is successful and User lands on Views Savings Screen and Sees Last Deposit Transaction {string}")
	public void transaction_is_successful_and_user_lands_on_views_savings_screen_and_sees_last_deposit_transaction(
			String expectedAmt) {
			Assert.assertEquals(expectedAmt, vsp.getDepositAmount());
			log.debug("Amount Deposit Success.");
			
	}

	@Then("Transaction is successful and User lands on Views Savings Screen and Sees Last Transaction {string}")
	public void transaction_is_successful_and_user_lands_on_views_savings_screen_and_sees_last_transaction(
			String amountDeducted) {
		{
			Assert.assertEquals(amountDeducted, vsp.getWithdrawAmount());
			log.debug("Amount Withdrawl Success.");
		}

	}
}