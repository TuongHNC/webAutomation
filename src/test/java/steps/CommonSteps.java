package steps;

import com.aventstack.extentreports.Status;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.ScenarioImpl;
import execution.BaseSteps;
import extentreport.ExtentManager;
import extentreport.ExtentTestManager;
import gherkin.formatter.model.Result;
import org.apache.commons.lang.reflect.FieldUtils;
import utilities.ActionWebUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class CommonSteps extends BaseSteps {

    @Before("@SmokeTest")
    public void before(Scenario scenario) {
        ActionWebUtils.sleep(1000);
        ExtentTestManager.startTest(scenario.getName(), scenario.getSourceTagNames().toString());
        ExtentTestManager.getTest().log(Status.INFO, "Scenario started : - " + scenario.getName());
    }

    @After("@SmokeTest")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            ExtentTestManager.addScreenShotsOnFailure();
            ExtentTestManager.logFail(logError(scenario));
        } else
            ExtentTestManager.scenarioPass();

        ExtentManager.getReporter().flush();
    }

    private static String logError(Scenario scenario) {
        String error = "";
        Field field = FieldUtils.getField(((ScenarioImpl) scenario).getClass(), "stepResults", true);
        field.setAccessible(true);
        try {
            ArrayList<Result> results = (ArrayList<Result>) field.get(scenario);
            for (Result result : results) {
                if (result.getError() != null)
                    error = result.getErrorMessage().replace("at ", "<br>at ");
            }
        } catch (Exception e) {
            return "Error while logging error : " + e;
        }
        return error;
    }
}
