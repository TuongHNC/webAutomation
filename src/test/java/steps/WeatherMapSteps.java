package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import execution.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pom.WeatherMapPage;
import utilities.ActionWebUtils;

public class WeatherMapSteps extends BaseSteps {

//    private WebDriver driver;

    private WeatherMapPage weatherMapPage = new WeatherMapPage(getDriver());

//    @Before
//    public void setUp() {
//        driver = getDriver();
//    }

    @After
    public void tearDown(){
        closeDriver();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Given("^user navigates to the URL '(.*?)'$")
    public void user_navigates_to_the_URL(String url) {
//        driver.get(url);
        getDriver().get(url);
    }

    @When("^input search \"([^\"]*)\" into the search text field$")
    public void inputSearchAbcIntoTheSearchTextField(String cityName) {
        weatherMapPage.inputSearch(cityName);
    }

    @And("^click on the search icon$")
    public void clickOnTheSearchIcon() {
        weatherMapPage.clickOnSearchIcon();
    }

    @Then("^validate the result is displayed$")
    public void validateTheResultIsDisplayed() {
        // Verify the result is displayed
        Assert.assertTrue(weatherMapPage.doesTheResultDiplayed(), "Verify the result is displayed");
    }

    @When("^click on the city name in the result$")
    public void clickOnTheCityNameInTheResult() {
        weatherMapPage.clickOnSearchHyperlink();
        ActionWebUtils.sleep(10000);
    }
}
