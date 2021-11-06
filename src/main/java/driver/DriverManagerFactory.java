package driver;

import constants.LogConstants;
import exception.WebApplicationFrameworkException;

public class DriverManagerFactory {

    private DriverManagerFactory() {
    }

    private static AbstractDriverManager driverManager;

    public static AbstractDriverManager getExistingManager() {
        if (driverManager == null) {
            throw new WebApplicationFrameworkException(LogConstants.FAILED_DUE_TO_REASONS
                    + "\n" + LogConstants.MAKE_SURE_YOU_ADD_SONIC_PHASES_FOR_THE_RUNNER
                    + "\n" + LogConstants.REQUIRED_INIT_DRIVER_MANAGER);
        }
        return driverManager;
    }

    public static AbstractDriverManager getManager(DriverType type) {
        switch (type) {
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;

    }
}
