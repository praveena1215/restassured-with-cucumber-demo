package options;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumberReport/report.html",
		"html:target/cucumberReport", "json:target/cucumberReport/cucumber-json-report.json",
		"junit:target/cucumberReport/cucumber.xml" }, tags = {
				"@weather" }, glue = { "stepdefs" }, features = { "src/test/features" })
public class CucumberTests extends AbstractTestNGCucumberTests {
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	     Reporter.setSystemInfo("Selenium", "3.7.0");
	     Reporter.setSystemInfo("Maven", "3.5.2");
	     Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}
