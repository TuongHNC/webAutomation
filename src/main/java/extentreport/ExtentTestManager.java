package extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentTestManager {

    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
    static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest() {
        return testReport.get();
    }

    public static void logInfo(String message) {
        testReport.get().info(message);
    }

    public static void logPass(String message) {
        testReport.get().pass(message);
    }

    public static void scenarioPass() {
        String passLogg = "SCENARIO PASSED";
        Markup m = MarkupHelper.createLabel(passLogg, ExtentColor.GREEN);
        testReport.get().log(Status.PASS, m);
    }

    public static void logFail(String message) {
        testReport.get().fail(message);
    }

    public static synchronized boolean addScreenShotsOnFailure() {
        String failureLogg = "SCENARIO FAILED";
        Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);

        ExtentManager.captureScreenshot();
        if (ExtentManager.encodedBase64image != null) {
            testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>" + "\n"
                    + "<img style='width:auto;max-width:50%;height:auto;max-height:50%;' "
                    + "src='data:img/png;base64,"
                    + ExtentManager.encodedBase64image + "'"
                    + "/>");
        }
        return true;
    }

    public static synchronized boolean addScreenShots() {
        ExtentManager.captureScreenshot();
        if (ExtentManager.encodedBase64image != null) {
            testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>" + "\n"
                    + "<img style='width:auto;max-width:50%;height:auto;max-height:50%;' "
                    + "src='data:img/png;base64,"
                    + ExtentManager.encodedBase64image + "'"
                    + "/>");
        }
        return true;
    }

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        testReport.set(test);
        return test;
    }
}
