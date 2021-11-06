package extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import driver.DriverManagerFactory;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ExtentManager {

    private final static Logger logger = Logger.getLogger(ExtentManager.class);

    static ExtentReports extentReports;
    static Date d = new Date();

    public static String encodedBase64image = null;

    public static String fileName = "Extent_" + d.toString().replace(":", "_")
            .replace(" ", "_") + ".html";

    public static ExtentReports getReporter() {
        if (extentReports == null) {

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
                    System.getProperty("user.dir") + "/reports/" + fileName);

            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle(fileName);
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName(fileName);

            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
            extentReports.setSystemInfo("Organization", "KTVN");
            extentReports.setSystemInfo("Product", "System Management");
        }
        return extentReports;
    }

    public static String screenshotName;
    static int i = 0;

    public static void captureScreenshot() {
        i = i + 1;
        File scrFile = ((TakesScreenshot) DriverManagerFactory.getExistingManager()
                .getDriver()).getScreenshotAs(OutputType.FILE);

        Date d = new Date();
        screenshotName = d.toString().replace(":", "_")
                .replace(" ", "_") + "_" + i + ".jpg";

        try {
            FileUtils.copyFile(scrFile,
                    new File(System.getProperty("user.dir") + "/reports/" + screenshotName));
            encodedBase64image = getBase64StringFromImage(System.getProperty("user.dir")
                    + "/reports/" + screenshotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBase64StringFromImage(String filePath) {
        try {
            File file = new File(filePath);
            byte[] bytes = FileUtils.readFileToByteArray(file);
            encodedBase64image = new String(Base64.encodeBase64(bytes));
        } catch (IOException e) {
            logger.error("Cannot convert image file:\n" + e);
        }

        return encodedBase64image;
    }
}
