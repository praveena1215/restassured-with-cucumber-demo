package options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumberReport",
		"json:target/cucumberReport/cucumber-json-report.json", "junit:target/cucumberReport/cucumber.xml" }, tags = {
				"@weather" }, glue = { "stepdefs" }, features = { "src/test/features" })
public class CucumberTests {
}
