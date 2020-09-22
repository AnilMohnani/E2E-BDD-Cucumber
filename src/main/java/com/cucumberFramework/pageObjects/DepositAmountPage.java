package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;

public class DepositAmountPage {
WebDriver driver;
	public DepositAmountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="id")
	public WebElement selectDropDown;
	
	@FindBy(id="amount")
	public WebElement depositAmount;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
	public WebElement submitBtn;
	
	public void selectTestAccountForDeoposit(String value) {
		BrowserActions.selectByValue(selectDropDown, value);
	}
	
	public void enterDepositAmount(String data)
	{
		BrowserActions.sendKeysData(depositAmount, data);
	}
	public ViewSavingsPage clickSubmitBtnAfterDeposotAmtEntered()
	{
		BrowserActions.elementClick(submitBtn);
		return new ViewSavingsPage(driver);
	}

}
