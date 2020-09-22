package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;

public class MyProfilePage		
{
		WebDriver driver;	
		public MyProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(id="region")
		public WebElement profileRegion;
		
		@FindBy(xpath="//*[@class='btn btn-primary btn-sm']")
		public WebElement submitBtn;
		
		@FindBy(css="span.badge.badge-pill.badge-success")
		public WebElement successMsg;
		
		public void deletePreviousRegionData() {
			BrowserActions.clearField(profileRegion);
		}
		
		
		public void enterNewRegionData(String newRegionData)
		{
			BrowserActions.sendKeysData(profileRegion,newRegionData);
			
		}
		public void scrollTillElement()
		{
			ResusableFunctions.scrollTillElement(profileRegion);
		}
		public void clickSubmit()
		{
			BrowserActions.elementClick(submitBtn);
		}
		public String getSuccessMessage()
		{
			return BrowserActions.getText(successMsg);
		}
		
}
