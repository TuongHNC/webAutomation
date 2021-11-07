package execution;

import configs.FrameworkConfig;
import driver.AbstractDriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import gherkin.formatter.Formatter;
import gherkin.formatter.model.*;
import org.apache.log4j.Logger;

import java.util.List;

public class WebPhases implements Formatter  {

    private static final Logger LOGGER = Logger.getLogger(WebPhases.class);

    private static AbstractDriverManager driverManager;
    private Feature feature;
    private Scenario scenario;


    @Override
    public void syntaxError(String s, String s1, List<String> list, String s2, Integer integer) {

    }

    @Override
    public void uri(String s) {

    }

    @Override
    public void feature(Feature feature) {
        LOGGER.info("\n\n\n======================== START THE TEST FOR FEATURE >>>> " + feature.getName() + " ========================");
        this.feature = feature;
        driverManager = DriverManagerFactory.getManager(DriverType.of(
                FrameworkConfig.getInstance().getProperty("test.configuration.browser")));
    }

    @Override
    public void scenarioOutline(ScenarioOutline scenarioOutline) {

    }

    @Override
    public void examples(Examples examples) {

    }

    @Override
    public void startOfScenarioLifeCycle(Scenario scenario) {
    }

    @Override
    public void background(Background background) {

    }

    @Override
    public void scenario(Scenario scenario) {
        this.scenario = scenario;
        LOGGER.info("------------ START THE TEST FOR SCENARIO >>>> " + scenario.getName() + " ------------");
    }

    @Override
    public void step(Step step) {
    }

    @Override
    public void endOfScenarioLifeCycle(Scenario scenario) {
    }

    @Override
    public void done() {
    }

    @Override
    public void close() {
    }

    @Override
    public void eof() {
        LOGGER.info("\n======================== END THE TEST FOR FEATURE >>>> " + feature.getName() + " ========================\n\n\n");
        driverManager.quitDriver();
    }
}
