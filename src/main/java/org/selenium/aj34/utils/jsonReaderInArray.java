package org.selenium.aj34.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class jsonReaderInArray {
    public static String getJsonValue(String obj, String fileNme) {
        File srcFile = new File(System.getProperty("user.dir") +
                "\\src\\test\\resources\\" + fileNme);
        JSONParser parser = new JSONParser();
        String value = null;
        try {
            JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));
            for (Object jsonObj : jArray) {
                JSONObject person = (JSONObject) jsonObj;
                value = (String) person.get(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
