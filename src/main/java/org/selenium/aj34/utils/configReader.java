package org.selenium.aj34.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    public static String readKey(String key){
        FileInputStream fis = null;
        Properties prop = null;

        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop.getProperty(key);

    }
}
