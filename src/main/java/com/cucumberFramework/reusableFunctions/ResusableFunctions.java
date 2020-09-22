package com.cucumberFramework.reusableFunctions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.cucumberFramework.helper.ExcelHelper;
import com.cucumberFramework.pageObjects.BankLoginPage;
import com.cucumberFramework.pageObjects.MyHomeBankPage;
import com.cucumberFramework.testBase.TestBase;

public class ResusableFunctions extends TestBase {
	ExcelHelper excelHelper = new ExcelHelper();
	static HashMap<String, String> map = ExcelHelper.getExcelData(testDataPath,"loginData");
	static JavascriptExecutor js;

	public static MyHomeBankPage login() throws IOException {
		BankLoginPage lp = new BankLoginPage(driver);
		lp.enterUsername(prop.getProperty("username"));
		lp.enterPassword(prop.getProperty("password"));
		lp.signInButtonClick();
		return new MyHomeBankPage(driver);

	}

	public static MyHomeBankPage newlogin() {
		BankLoginPage lp = new BankLoginPage(driver);
		lp.enterUsername(map.get("username"));
		lp.enterPassword(map.get("password"));
		lp.signInButtonClick();
		return new MyHomeBankPage(driver);

	}

	public static void clickUsingJavaScriptExecutor(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void scrollTillElement(WebElement element) {
		
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void scrollPage() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");	
		}

	public static String getBase64Screenshot(String name) throws IOException {
		String Base64StringofScreenshot = "";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date odate = new Date();
		SimpleDateFormat oSDF = new SimpleDateFormat("ddMMYYYY_HHmmss");
		String sDate = oSDF.format(odate);
		FileUtils.copyFile(src, new File(screenshotdir + name + "_" + sDate + ".png"));

		byte[] fileContent = FileUtils.readFileToByteArray(src);
		Base64StringofScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
		return Base64StringofScreenshot;

	}
	public static String getSubstring(String s,int x,int y)
	{
		return s.substring(x, y);
		
	}
}
