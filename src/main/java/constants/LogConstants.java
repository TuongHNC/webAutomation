package constants;

public class LogConstants {
    private LogConstants() {
    }

    //Selenium handling log
    public static final String CANNOT_START_SELENIUM_SERVICE = "Cannot start selenium service!! Please check your service config >>>";

    public static final String FAILED_DUE_TO_REASONS = "Failure due to reasons: ";

    public static final String REQUIRED_INIT_DRIVER_MANAGER = "- Initialize driver manager before using existing driver manager!!!";

    public static final String MAKE_SURE_YOU_ADD_SONIC_PHASES_FOR_THE_RUNNER = "- Make sure you have added SonicPhases for your runner!!!";

    //Environment log
    public static final String CANNOT_GET_PROPERTIES_FROM_FILE = "Cannot get properties from file, please check your file path >>>> ";

    public static final String TARGET_PROPERTIES_NULL = "Target properties is null >>> ";

    public static final String LOAD_CONFIGURATION_PROPERTIES_SUCCESS= "Loaded configuration properties from external file >>> ";

    //Reporting log
    public static final String NONE_REPORT_FILE_WAS_FOUND= "None report file was found!";

    public static final String REPORTING_PROGRESS_IS_RUNNING = "Reporting progress is running....";

    public static final String REPORTING_PROGRESS_COMPLETED = "Reporting progress is completed!";

    //Util log
    public static final String CREATE_FILE_FAILED = "Create file failed >>>> ";

    public static final String COPY_FILE_FAILED = "Copy file failed >>>> ";

    public static final String MULTIPLE_DIRECTORIES_ARE_CREATED = "Multiple directories are created successfully!";

    public static final String FAILED_TO_CREATE_MULTIPLE_DIRECTORIES = "Failed to create multiple directories!";

    public static final String COPY_DIRECTORY_FAILED = "Copy directory failed >>>> ";
}
