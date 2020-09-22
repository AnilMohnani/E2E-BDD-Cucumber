package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;
import com.cucumberFramework.helper.WaitHelper;

public class BankRegistrationPage2 {
	WebDriver driver;
	WaitHelper waitHelper;

	public BankRegistrationPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	@FindBy(css = "#address")
	public WebElement address;

	@FindBy(id = "locality")
	public WebElement locality;

	@FindBy(id = "region")
	public WebElement region;

	@FindBy(id = "postalCode")
	public WebElement zipcode;

	@FindBy(css = "#country")
	public WebElement country;

	@FindBy(id = "mobilePhone")
	public WebElement mobNo;

	@FindBy(xpath = "//*[@id='workPhone']")
	public WebElement workNo;

	@FindBy(css = "#homePhone")
	public WebElement homePhone;

	@FindBy(id = "agree-terms")
	public WebElement terms;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement registerBtn;

	public void enterAddress(String addressData) {
		waitHelper.waitForElement(address);
		BrowserActions.sendKeysData(address, addressData);
	}

	public void enterLocality(String localityData) {
		BrowserActions.sendKeysData(locality, localityData);
	}

	public void enterRegion(String regionData) {
		BrowserActions.sendKeysData(region, regionData);
	}

	public void enterCountry(String countryData) {
		BrowserActions.sendKeysData(country, countryData);
	}

	public void enterZipcode(String zipcodeData) {
		BrowserActions.sendKeysData(zipcode, zipcodeData);
	}

	public void enterHomePhone(String homePhoneData) {
		BrowserActions.sendKeysData(homePhone, homePhoneData);
	}

	public void enterWorkPhone(String workPhoneData) {
		BrowserActions.sendKeysData(workNo, workPhoneData);
	}

	public void enterMobilePhone(String mobPhoneData) {
		BrowserActions.sendKeysData(mobNo, mobPhoneData);
	}

	public void clickAgree() {
		BrowserActions.elementClick(terms);
	}

	public void clickRegisterButton() {
		BrowserActions.elementClick(registerBtn);
	}

}
