package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = {"src/test/java/features/Weathermap.feature"},
        plugin = {"execution.WebPhases", "html:report", "json:target/surefire-reports/cucumber-json-report.json", "html:allure-report"},
        glue = "steps",
        tags = "@SmokeTest")

public class WeatherMapRunner extends AbstractTestNGCucumberTests {

}
