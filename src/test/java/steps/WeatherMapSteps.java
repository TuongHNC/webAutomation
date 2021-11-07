package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import execution.BaseSteps;
import org.openqa.selenium.WebDriver;
import utilities.ActionWebUtils;

public class WeatherMapSteps extends BaseSteps {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = getDriver();
    }

    @After
    public void tearDown(){
        closeDriver();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Given("^user navigates to the URL '(.*?)'$")
    public void user_navigates_to_the_URL(String url) {
        driver.get(url);
    }

    @Then("^user wait for 10 seconds")
    public void userWaitFor10Seconds() {
        ActionWebUtils.sleep(10000);
    }
}
