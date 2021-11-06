package config;

import constants.LogConstants;
import constants.WebApplicationConstant;
import exception.WebApplicationFrameworkException;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkConfig {
    private static final Logger LOGGER = Logger.getLogger(FrameworkConfig.class);

    private static FrameworkConfig instance;
    private static Properties properties;

    public FrameworkConfig(String configFilePath) {
        properties = getProperties(configFilePath);
    }

    public static FrameworkConfig getInstance() {
        if (instance == null) {
            instance = new FrameworkConfig(WebApplicationConstant.FRAMEWORK_CONFIG_FILE_PATH);
        }
        return instance;
    }

    public String getProperty(final String keyName) {
        String value = properties.getProperty(keyName);
        if (value == null) {
            LOGGER.warn(LogConstants.TARGET_PROPERTIES_NULL + keyName);
        }
        return value;
    }

    private Properties getProperties(final String filePath) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(filePath)) {
            prop.load(input);
        } catch (IOException e) {
            throw new WebApplicationFrameworkException(LogConstants.CANNOT_GET_PROPERTIES_FROM_FILE, e);
        }
        LOGGER.info(LogConstants.LOAD_CONFIGURATION_PROPERTIES_SUCCESS + filePath);
        return prop;
    }
}
