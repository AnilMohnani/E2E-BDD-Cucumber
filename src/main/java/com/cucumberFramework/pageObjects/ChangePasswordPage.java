package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.BrowserActions;
import com.cucumberFramework.testBase.TestBase;

public class ChangePasswordPage extends TestBase {
	WebDriver driver;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "currentPassword")
	public WebElement currentPassword;

	@FindBy(id = "newPassword")
	public WebElement newPassword;

	@FindBy(id = "confirmPassword")
	public WebElement confirmPassword;

	@FindBy(css = "#payment-button")
	public WebElement updatePasswordBtn;

	@FindBy(css = "span.badge.badge-pill.badge-success")
	public WebElement updatePasswordSuccessMessage;

	@FindBy(xpath = "//*[@class='badge badge-pill badge-danger']")
	public WebElement incorrectPasswordMsg;

	public void enterCurentPassword(String currentPasswordData) {
		BrowserActions.sendKeysData(currentPassword, currentPasswordData);
	}

	public void enterNewPassword(String newPasswordData) {
		BrowserActions.sendKeysData(newPassword, newPasswordData);
	}

	public void enterConfirmPassword(String confirmPasswordData) {
		BrowserActions.sendKeysData(confirmPassword, confirmPasswordData);
	}

	public void clickUpdatePassswordBtn() {
		BrowserActions.elementClick(updatePasswordBtn);
	}

	public String getUpdatePasswordSuccess() {
		return BrowserActions.getText(updatePasswordSuccessMessage);
	}

	public String getIncorrectPasswordErrorMsg() {
		return BrowserActions.getText(incorrectPasswordMsg);

	}

}
