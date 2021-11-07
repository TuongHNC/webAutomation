package driver;

import configs.FrameworkConfig;
import constants.LogConstants;
import exception.WebApplicationFrameworkException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ChromeDriverManager extends AbstractDriverManager {

    private ChromeDriverService chService;

    @Override
    void startService() {
        if (null == chService) {
            try {
                chService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(
                                FrameworkConfig.getInstance().getProperty("selenium.webdriver.chromebrowser.path")))
                        .usingAnyFreePort()
                        .build();
                chService.start();
            } catch (Exception e) {
                throw new WebApplicationFrameworkException(LogConstants.CANNOT_START_SELENIUM_SERVICE + e);
            }
        }
    }

    @Override
    void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

    @Override
    void createDriver() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        options.addArguments("start-maximised");
        options.setAcceptInsecureCerts(Boolean.parseBoolean(
                FrameworkConfig.getInstance().getProperty("selenium.acceptInsecureCerts")));
        options.setHeadless(Boolean.parseBoolean(FrameworkConfig.getInstance().getProperty("selenium.headless")));
        System.setProperty("webdriver.chrome.driver", FrameworkConfig.getInstance().getProperty("selenium.webdriver.chromebrowser.path"));
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverThreadLocal.set(driver);
    }

    @Override
    void createRemoteDriver() {

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.ANY);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("start-maximised");
        options.addArguments("--incognito");
        options.setAcceptInsecureCerts(Boolean.parseBoolean(
                FrameworkConfig.getInstance().getProperty("selenium.acceptInsecureCerts")));
        options.setHeadless(Boolean.parseBoolean(FrameworkConfig.getInstance().getProperty("selenium.headless")));
        options.merge(cap);

        try {
            driverThreadLocal.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        getRemoteDriver().manage().window().maximize();
        getRemoteDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
