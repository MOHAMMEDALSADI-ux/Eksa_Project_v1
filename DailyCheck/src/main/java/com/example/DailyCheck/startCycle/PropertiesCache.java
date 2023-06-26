package com.example.DailyCheck.startCycle;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesCache {

    private static final String CONFIG_FILE_PATH = "C:\\Users\\m.alsadi\\Intellij Project\\DailyCheck\\src\\main\\resources\\application.properties";
    private static Map<String, String> propertiesCache;

    public static void loadProperties(){

        propertiesCache = new HashMap<>();

        try( FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH))  {
            Properties properties = new Properties();
            properties.load(fis);

            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                propertiesCache.put(key, value);
            }

            System.out.println("Properties loaded and cached successfully.");
        } catch (IOException e) {
            System.err.println("Error loading properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return propertiesCache.get(key);
    }
}
