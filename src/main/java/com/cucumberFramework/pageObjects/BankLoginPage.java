package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;

public class BankLoginPage {

	WebDriver driver;
	WaitHelper waitHelper;

	public BankLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(css = "#password")
	public WebElement password;

	@FindBy(xpath = "//*[@id='submit']")
	public WebElement signInButton;

	@FindBy(xpath = "//a[contains(text(),'Sign Up Here')]")
	public WebElement signUpNavigationLink;

	@FindBy(xpath = "//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
	public WebElement loginErrorMessage;
	
	@FindBy(css="span.badge.badge-pill.badge-danger")
	public WebElement shortLoginError;

	@FindBy(xpath = "//*[@class='badge badge-pill badge-success']")
	public WebElement registrationSuccess;

	@FindBy(css = "span.badge.badge-pill.badge-success")
	public WebElement logoutSuccess;

	public void enterUsername(String usernameData) {
		BrowserActions.sendKeysData(username, usernameData);
	}

	public void enterPassword(String passwordData) {
		BrowserActions.sendKeysData(password, passwordData);
	}

	public MyHomeBankPage signInButtonClick() {
		BrowserActions.elementClick(signInButton);
		return new MyHomeBankPage(driver);

	}

	public BankRegistrationPage1 navigateToSignupPage() {
		BrowserActions.elementClick(signUpNavigationLink);
		return new BankRegistrationPage1(driver);
	}

	public String getLoginErrorMessage() {
		waitHelper.waitForElement(loginErrorMessage);
		String shortError=BrowserActions.getText(shortLoginError);
		int first=shortError.length();
		String errorMsg = BrowserActions.getText(loginErrorMessage);
		int last=errorMsg.length();
		System.out.println(first);
		System.out.println(last);
		String finalError = ResusableFunctions.getSubstring(errorMsg, 6,48);
		return finalError;

	}

	public String getRegistrationSuccess() {
		waitHelper.waitForElement(registrationSuccess);
		return BrowserActions.getText(registrationSuccess);
	}

	public String getLogoutSuccessValidator() {
		return BrowserActions.getText(logoutSuccess);

	}
}
