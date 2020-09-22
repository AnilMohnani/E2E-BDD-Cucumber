package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.reusableFunctions.ResusableFunctions;
import com.cucumberFramework.testBase.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends TestBase {
	WebDriver driver;
	WaitHelper waitHelper;
	private static final org.apache.logging.log4j.Logger log = LoggerHelper.getLogger(Hooks.class);	
	@Before
	public void setUp() {
		try {
			driver = browserInitialisation();
			driver.get(prop.getProperty("bankUrl"));
			log.info("Browser launched successfully");
			log.info("-------------------------------------------------");

		} catch (Exception e) 
		{
			System.out.println("Website Not Working.Please try later");
			log.error("Website is not working. Url cannot be launched");
			System.out.println(e.getMessage());
		}

	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		TakesScreenshot ts;
		ts = (TakesScreenshot) TestBase.driver;
		final byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		// scenario.embed(screenshot,"image/png");
		scenario.attach(screenshot, "image/png", scenario.getName());
		log.info("Screenshot attached successfully after test failure");
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ResusableFunctions.getBase64Screenshot(scenario.getName()),scenario.getName());
		scenario.log("screenshot attached");
		driver.close();
		log.info("Browser closed successfully");
		log.info("-------------------------------------------------");


	}
}
