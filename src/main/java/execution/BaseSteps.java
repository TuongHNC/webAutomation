package execution;

import driver.DriverManagerFactory;
import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {

    protected WebDriver getDriver() {

        if (Boolean.parseBoolean(System.getProperty("seleniumGrid")))
            return DriverManagerFactory.getExistingManager().getRemoteDriver();
        else
            return DriverManagerFactory.getExistingManager().getDriver();
    }

    protected void closeDriver() {
        DriverManagerFactory.getExistingManager().quitDriver();
    }
}
