package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src\\test\\java\\features\\bankLogin.feature", glue = "stepDefinitions", plugin = {
		"pretty", "html:target/report.html","json:target/report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true,dryRun=false)
public class TestRunner {
	
	
}


