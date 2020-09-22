package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;

public class WithdrawAmountPage {
	WebDriver driver;

	public WithdrawAmountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id")
	public WebElement selectAccountDropDown;
	
	@FindBy(id="amount")
	public WebElement amountToWithdraw;
	
	@FindBy(xpath="//*[@class='btn btn-primary btn-sm']")
	public WebElement submitBtn;
	
	public void selectTestAccount(String value) {
		BrowserActions.selectByValue(selectAccountDropDown, value);
	}
	public void enterWithdrawalAmount(String amt)
	{
		BrowserActions.sendKeysData(amountToWithdraw, amt);
	}
	public ViewSavingsPage submitBtnClick()
	{
		BrowserActions.elementClick(submitBtn);
		return new ViewSavingsPage(driver);
	}

}
