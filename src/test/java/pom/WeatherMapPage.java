package pom;

import configs.FrameworkConfig;
import helpers.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WeatherMapPage {

    private WebDriver driver;

    public WeatherMapPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(
                FrameworkConfig.getInstance().getProperty("test.configuration.loadingTimeout")), TimeUnit.SECONDS);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final By SEARCH_TEXT_FIELD_BY = By.xpath("//input[@id='search_str']");
    public static final By SEARCH_ICON_BY = By.cssSelector(".btn-color");
    public static final By SEARCH_RESULT_BY = By.xpath("//table[@class='table']//b//a");

    //------------------------------------------------------------------------------------------------------------------

    public void inputSearch(String searchString) {
        WebElementHelper.waitForPresenceOfElementLocated(SEARCH_TEXT_FIELD_BY).clear();
        WebElementHelper.waitForPresenceOfElementLocated(SEARCH_TEXT_FIELD_BY).sendKeys(searchString);
    }

    public void clickOnSearchIcon() {
        WebElementHelper.waitForPresenceOfElementLocated(SEARCH_ICON_BY).click();
    }

    public boolean doesTheResultDiplayed() {
        return WebElementHelper.findElement(SEARCH_RESULT_BY).isDisplayed();
    }

    public void clickOnSearchHyperlink() {
        WebElementHelper.waitForPresenceOfElementLocated(SEARCH_RESULT_BY).click();
    }
}
