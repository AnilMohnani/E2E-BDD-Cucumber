package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;
import com.cucumberFramework.helper.WaitHelper;

public class BankRegistrationPage1 {
	WebDriver driver;
	WaitHelper waitHelper;
	public BankRegistrationPage1(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waitHelper=new WaitHelper(driver);
	}
	
	@FindBy(css="#title")
	public WebElement title;
	
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@value='M']")
	public WebElement maleSelection;
	
	@FindBy(xpath="//input[@value='F']")
	public WebElement femaleSelection;
	
	@FindBy(name="dob")
	public WebElement dateOfBirth;
	
	@FindBy(id="ssn")
	public WebElement ssn;
	
	@FindBy(xpath="//*[@id='emailAddress']")
	public WebElement emailId;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="confirmPassword")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement nextBtn;
	
	public void selectTitle(String titleValue)
	{
	waitHelper.waitForElement(title);
	BrowserActions.elementClick(title);
	BrowserActions.selectByValue(title, titleValue);	
	}
	
	public void enterFirstname(String firstNameValue)
	{
		BrowserActions.sendKeysData(firstName, firstNameValue);
	}
	public void enterLastname(String lastNameValue)
	{
		BrowserActions.sendKeysData(lastName, lastNameValue);
	}
	public void selectGender()
	{
		BrowserActions.elementClick(maleSelection);
	}
	public void enterDOB(String dobData)
	{
		BrowserActions.sendKeysData(dateOfBirth, dobData);
	}
	public void enterSSN(String ssnData)
	{
		BrowserActions.sendKeysData(ssn, ssnData);
	}
	public void enterEmail(String emailData)
	{
	BrowserActions.sendKeysData(emailId, emailData);	
	}
	public void enterPassword(String passwordData)
	{
		BrowserActions.sendKeysData(password, passwordData);
	}
	public void enterCnfPassword(String passwordCnfData)
	{
		BrowserActions.sendKeysData(confirmPassword, passwordCnfData);
	}
	public BankRegistrationPage2 clickNext()
	{
		BrowserActions.elementClick(nextBtn);
		return new BankRegistrationPage2(driver);
	}
	
	}
