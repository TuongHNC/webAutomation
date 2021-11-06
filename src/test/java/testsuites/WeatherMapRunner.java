package testsuites;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/features/Weathermap.feature"},
        plugin = {"execution.WebPhases", "json:target/report.json",
                "io.qameta.allure.cucumberjvm.AllureCucumberJvm"},
        glue = "steps",
        tags = {"@parallel"}
)

public class WeatherMapRunner extends AbstractTestNGCucumberTests {

}
