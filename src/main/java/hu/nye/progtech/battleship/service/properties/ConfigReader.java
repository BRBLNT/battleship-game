package hu.nye.progtech.battleship.service.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Read configuration from file if user do not give explicit config system automatically read config.properties
 */
public final class ConfigReader {
    private static final Properties PROP = new Properties();
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigReader.class);
    private static String NAME_PROPERTIES_FILE = "config.properties";

    public ConfigReader(String config) throws ConfigurationNotFoundException {
        if (config.length() < 1) {
            readProperties(config);
        } else {
            readProperties();
        }
    }

    private static void readProperties() throws ConfigurationNotFoundException {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(NAME_PROPERTIES_FILE)) {
            PROP.load(input);
            LOGGER.info("read config file successfully!");
        } catch (IOException ex) {
            LOGGER.error("configuration is missing!");
            throw new ConfigurationNotFoundException("Cannot load configuration file! Failed to start game!");
        }
    }

    private static void readProperties(String config) throws ConfigurationNotFoundException {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(config)) {
            PROP.load(input);
            LOGGER.info("read config file successfully!");
        } catch (IOException ex) {
            LOGGER.error("configuration is missing!");
            throw new ConfigurationNotFoundException("Cannot load configuration file! Failed to start game!");
        }
    }

    public static Properties getProp() {
        return PROP;
    }

    public static String getPropertyFromConfig(String key) {
        return PROP.getProperty(key);
    }
}
