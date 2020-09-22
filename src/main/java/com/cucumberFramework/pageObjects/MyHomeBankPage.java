package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;

public class MyHomeBankPage {
	WebDriver driver;
	WaitHelper waitHelper;

	public MyHomeBankPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	@FindBy(xpath = "//li[contains(text(),'Welcome')]")
	public WebElement welcomeText;

	@FindBy(css = "img.user-avatar.rounded-circle")
	public WebElement profileDropdown;

	@FindBy(xpath = "//*[@href='/user/password']")
	public WebElement changePasswordLink;

	@FindBy(xpath = "//*[@href='/user/profile']")
	public WebElement myProfileLink;

	@FindBy(id = "savings-menu")
	public WebElement savingsDropDown;

	@FindBy(id = "new-savings-menu-option")
	public WebElement newSavingsLink;

	@FindBy(css = "i.menu-icon.fa.fa-book")
	public WebElement transactionsDropDown;

	@FindBy(xpath = "//*[@href='/account/withdraw']")
	public WebElement withdrawAmtLink;

	@FindBy(xpath = "//*[@href='/account/deposit']")
	public WebElement depositAmtLink;
	
	@FindBy(xpath="//h3[contains(text(),'3rd Party Transfers')]//following::li")
	public WebElement visaDirectLink;
	
	@FindBy(xpath="//a[contains(text(),'VISA Transfer')]")
	public WebElement visaTransferLink;
	
	@FindBy(xpath="//a[@href='/logout']")
	public WebElement logoutLink;

	public String getWelcomeText() {
		String text = BrowserActions.getText(welcomeText);
		return text;
	}

	public void clickImageIcon() {
		waitHelper.waitForElement(profileDropdown);
		ResusableFunctions.clickUsingJavaScriptExecutor(profileDropdown);
		// BrowserActions.elementClick(profileDropdown);
	}

	public ChangePasswordPage clickChangePasswordLink() {
		BrowserActions.elementClick(changePasswordLink);
		return new ChangePasswordPage(driver);
	}

	public MyProfilePage clickMyProfileLink() {
		BrowserActions.elementClick(myProfileLink);
		return new MyProfilePage(driver);
	}

	public void clickSavingsMenu() {
		BrowserActions.elementClick(savingsDropDown);
	}

	public NewSavingsAccountPage clickNewSavingsAccount() {
		BrowserActions.elementClick(newSavingsLink);
		return new NewSavingsAccountPage(driver);
	}

	public void clickTransactionsLink() {
		waitHelper.waitForElement(transactionsDropDown);
		BrowserActions.elementClick(transactionsDropDown);

	}

	public WithdrawAmountPage clickWithdrawLink() {
		BrowserActions.elementClick(withdrawAmtLink);
		return new WithdrawAmountPage(driver);
	}

	public DepositAmountPage clickDepositLink() {
		BrowserActions.elementClick(depositAmtLink);
		return new DepositAmountPage(driver);

	}
	
	public void clickVisaDirectLink()
	{
		BrowserActions.elementClick(visaDirectLink);
	}
	public VisaTransferPage clickVisaTransferLink()
	{
		BrowserActions.elementClick(visaTransferLink);
		return new VisaTransferPage(driver) ;
	}
	public BankLoginPage clickLogout()
	{
		BrowserActions.elementClick(logoutLink);
		return new BankLoginPage(driver);
	}
}