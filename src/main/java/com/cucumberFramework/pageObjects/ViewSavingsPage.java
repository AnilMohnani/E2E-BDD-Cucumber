package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;

public class ViewSavingsPage {
	WebDriver driver;

	public ViewSavingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='switch-input' and @checked='checked']//parent::label//following-sibling::div[@class='h4 m-0']")
	public WebElement activeAccount;

	@FindBy(xpath = "//td[contains(text(),'DPT')]//following-sibling::td")
	public WebElement depositAmtValue;
	
	@FindBy(xpath="//td[contains(text(),'WTH')]//following-sibling::td")
	public WebElement withdrawAmountValue;
	

	public String getActiveAccountName() {
		return BrowserActions.getText(activeAccount);
	}

	public String getWithdrawAmount() {
		ResusableFunctions.scrollPage();
		return BrowserActions.getText(withdrawAmountValue);	}
	
	public String getDepositAmount() {
		ResusableFunctions.scrollPage();
		return BrowserActions.getText(depositAmtValue);	
		}
}
