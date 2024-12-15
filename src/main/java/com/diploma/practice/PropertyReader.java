package com.diploma.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final java.util.Properties PROPERTIES = new Properties();

    public static void loadConfigProperties() {
        try (FileInputStream fileInputStreams = new FileInputStream("config.properties")) {
            PROPERTIES.load(fileInputStreams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String name){
        if (PROPERTIES.isEmpty()){
            loadConfigProperties();
        }
        return PROPERTIES.getProperty(name);
    }
}
