package com.cucumberFramework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserActions {

	private static final org.apache.logging.log4j.Logger log = LoggerHelper.getLogger(BrowserActions.class);

	WebDriver driver;

	public static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Element not found");
			log.error("Element Not Found");
			System.out.println(e.getMessage());
			log.error(e.getMessage(),"Element Not Found");

		}
	}

	public static void sendKeysData(WebElement element, String data) {
		try {
			element.sendKeys(data);

		} catch (Exception e) {
			System.out.println("There is some problem in finding the element");
			log.error("Data cannot be entered");
			System.out.println(e.getMessage());
		}
	}

	public static String getText(WebElement element) {
		String text = null;
		try {
			text = element.getText();
		} catch (Exception e) {
			System.out.println("Text not found");
			log.error("Text cannot be captured");
			System.out.println(e.getMessage());
		}
		return text;
	}

	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectByValue(WebElement element, String value) {
		try {
		Select select = new Select(element);
		select.selectByValue(value);
		}catch(Exception e)
		{
			System.out.println("Value cannot be selected");
			log.error("Value cannot be selected");
		}
	}

	public static void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public static void clearField(WebElement element)
	{
		element.clear();
	}

}
