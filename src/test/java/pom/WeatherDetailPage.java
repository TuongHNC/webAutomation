package pom;

import configs.FrameworkConfig;
import helpers.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WeatherDetailPage {

    private WebDriver driver;

    public WeatherDetailPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(
                FrameworkConfig.getInstance().getProperty("test.configuration.loadingTimeout")), TimeUnit.SECONDS);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final By CURRENT_DATE_TIME_TEXT_BY = By.cssSelector(".orange-text");
    public static final By CITY_COUNTRY_TEXT_BY = By.xpath("//div[@class='current-container mobile-padding']//h2");
    public static final By TEMPERATURE_TEXT_BY = By.cssSelector(".current-temp .heading");

    //------------------------------------------------------------------------------------------------------------------

    public String getTextDateTime() {
        return WebElementHelper.waitAndGetText(CURRENT_DATE_TIME_TEXT_BY);
    }

    public String getTextCityAndCountry() {
        return WebElementHelper.waitAndGetText(CITY_COUNTRY_TEXT_BY);
    }

    public String getTextTemperature() {
        return WebElementHelper.waitAndGetText(TEMPERATURE_TEXT_BY);
    }
}
