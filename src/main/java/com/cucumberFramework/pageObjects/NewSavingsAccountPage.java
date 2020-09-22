package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;

public class NewSavingsAccountPage {
	WebDriver driver;

	public NewSavingsAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Savings")
	public WebElement savingAccountRadioBtn;

	@FindBy(xpath = "//*[@id='Money Market']")
	public WebElement moneyMarketRadioBtn;

	@FindBy(xpath = "//*[@id='Individual']")
	public WebElement individualOwnership;

	@FindBy(id = "Joint")
	public WebElement jointAccount;

	@FindBy(name = "name")
	public WebElement accountName;

	@FindBy(id = "openingBalance")
	public WebElement initialDeposit;

	@FindBy(id = "newSavingsSubmit")
	public WebElement newSavingSummitBtn;

	public void chooseSavins() {
		BrowserActions.elementClick(savingAccountRadioBtn);
	}

	public void chooseIndividual() {
		BrowserActions.elementClick(individualOwnership);
	}

	public void chooseJoint() {
		BrowserActions.elementClick(jointAccount);
	}

	public void enterAccountName(String accountNameData) {
		BrowserActions.sendKeysData(accountName, accountNameData);
	}

	public void enterInitialDeposit(String initialDepositAmt) {
		BrowserActions.sendKeysData(initialDeposit, initialDepositAmt);

	}
	public ViewSavingsPage submitNewSavingsAccountCreation()
	{
		BrowserActions.elementClick(newSavingSummitBtn);
		return new ViewSavingsPage(driver);
	}
}