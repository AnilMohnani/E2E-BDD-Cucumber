package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;

public class VisaTransferPage {
	WebDriver driver;
	public VisaTransferPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="extAccount")
	public WebElement visaAccDropdown;
	
	@FindBy(xpath="//*[@id='extAmount']")
	public WebElement visaAmount;
	
	@FindBy(xpath="//*[@class='btn btn-primary btn-sm']")
	public WebElement submitBtn;
	
	public void selectVisaAccount(String value)
	{   BrowserActions.elementClick(visaAccDropdown);
		BrowserActions.selectByValue(visaAccDropdown, value);
	}
	
	public void enterVisaAmount(String data)
	{
		BrowserActions.sendKeysData(visaAmount, data);
	}
	public VisaDirectPaymentResponsePage clickVisaTransferScreenSubmit()
	{
		BrowserActions.elementClick(submitBtn);
		return new VisaDirectPaymentResponsePage(driver);
	}
}
