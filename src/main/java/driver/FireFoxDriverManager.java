package driver;

import config.FrameworkConfig;
import constants.LogConstants;
import exception.WebApplicationFrameworkException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FireFoxDriverManager extends AbstractDriverManager {

    private GeckoDriverService geckoDriverService;

    @Override
    void startService() {
        if (null == geckoDriverService) {
            try {
                geckoDriverService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File(
                                FrameworkConfig.getInstance().getProperty("selenium.webdriver.firefoxbrowser.path")))
                        .usingAnyFreePort()
                        .build();
                geckoDriverService.start();
            } catch (Exception e) {
                throw new WebApplicationFrameworkException(LogConstants.CANNOT_START_SELENIUM_SERVICE + e);
            }
        }
    }

    @Override
    void stopService() {
        if (null != geckoDriverService && geckoDriverService.isRunning())
            geckoDriverService.stop();
    }

    @Override
    void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverThreadLocal.set(driver);
    }

    @Override
    void createRemoteDriver() {
        // TODO - Not implement yet
    }
}
