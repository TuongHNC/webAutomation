package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dto.WeatherMapDTO;
import execution.BaseSteps;
import helpers.DateTimeHelper;
import org.testng.Assert;
import pom.WeatherDetailPage;
import pom.WeatherMapPage;
import utilities.ParseUtils;

public class WeatherMapSteps extends BaseSteps {


    private WeatherMapPage weatherMapPage = new WeatherMapPage(getDriver());
    private WeatherDetailPage weatherDetailPage = new WeatherDetailPage(getDriver());

    private WeatherMapDTO weatherMapDTO;

    public WeatherMapSteps(WeatherMapDTO weatherMapDTO) {
        this.weatherMapDTO = weatherMapDTO;
    }

    //------------------------------------------------------------------------------------------------------------------

    @After
    public void tearDown(){
        closeDriver();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Given("^user navigates to the URL '(.*?)'$")
    public void user_navigates_to_the_URL(String url) {
        getDriver().get(url);
    }

    @When("^input search \"([^\"]*)\" into the search text field$")
    public void inputSearchAbcIntoTheSearchTextField(String cityName) {
        weatherMapPage.inputSearch(cityName);
        weatherMapDTO.setCityName(cityName);
    }

    @And("^click on the search icon$")
    public void clickOnTheSearchIcon() {
        weatherMapPage.clickOnSearchIcon();
    }

    @Then("^verify the result is displayed$")
    public void validateTheResultIsDisplayed() {
        // Verify the result is displayed
        Assert.assertTrue(weatherMapPage.doesTheResultDiplayed(), "Verify the result is displayed");
    }

    @When("^click on the city name in the result$")
    public void clickOnTheCityNameInTheResult() {
        weatherMapPage.clickOnSearchHyperlink();
    }

    @Then("^verify the current date time$")
    public void verifyTheCurrentDateTime() {
        String actualDateTime = weatherDetailPage.getTextDateTime().split(",")[0];
        String expectedDateTime = DateTimeHelper.getcurrentDateTimeSymbol().split(",")[0];

        Assert.assertEquals(actualDateTime, expectedDateTime,
                "Verify the Date time is today with format MMM d. Eg: Nov 8");
    }


    @Then("^verify the city and country name$")
    public void verifyTheCityAndCountryName() {
        Assert.assertEquals(weatherDetailPage.getTextCityAndCountry(), weatherMapDTO.getCityName(),
                "Verify the City and Country name");
    }

    @Then("^validate the temperature display regardless its number$")
    public void validateTheTemperatureDisplayRegardlessItsNumber() {
        // Split the string and get number before the degree symbol (\\u00B0)
        String temperatureNumber = weatherDetailPage.getTextTemperature().split("\\u00B0")[0];

        // Validate it's a number
        Assert.assertTrue(ParseUtils.isNumeric(temperatureNumber),
                "Validate the Temperature display regardless its number");
    }
}
