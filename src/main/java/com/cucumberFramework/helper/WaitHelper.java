package com.cucumberFramework.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	WebDriver driver;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElement(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception val1) {
			System.out.println("Element Not Visible");
			System.out.println(val1.getMessage());
		}
	}

	public void waitForControl() throws InterruptedException {
		Thread.sleep(5000);

	}
	
	
}
