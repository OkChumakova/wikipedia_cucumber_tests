package utils;

import java.io.IOException;
import java.util.Properties;

public class FrameworkPropertyReader {
    static Properties prop;

    static void loadProperties() {
        if (prop != null) {
            return;
        }

        prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            prop.load(FrameworkPropertyReader.class.getClassLoader().getResourceAsStream("framework.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String getProperty(String propertyName) {
        loadProperties();

        if ((System.getProperty(propertyName) == null)) {
            return prop.getProperty(propertyName);
        } else {
            return System.getProperty(propertyName);
        }
    }

    public static String getUrl() {
        return getProperty("url");
    }

    public static Browser getBrowser() {
        return Browser.valueOf(getProperty("browser"));
    }
}
