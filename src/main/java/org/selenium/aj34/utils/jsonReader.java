package org.selenium.aj34.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class jsonReader {
    public static String getJsonValue(String obj, String fileNme) {
        File srcFile = new File(System.getProperty("user.dir") +
                "\\src\\test\\resources\\" + fileNme);
        JSONParser parser = new JSONParser();
        String value = null;
        try {
            JSONObject object = (JSONObject) parser.parse(new FileReader(srcFile));
            value =(String)object.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
