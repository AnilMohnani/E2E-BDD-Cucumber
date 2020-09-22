package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;

public class VisaDirectPaymentResponsePage {
	WebDriver driver;
public VisaDirectPaymentResponsePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(id="approvalStatus")
public WebElement verificationVisaPayment;

public String getverificationVisaPaymentSuccess()
{
	return BrowserActions.getText(verificationVisaPayment);
}
}
