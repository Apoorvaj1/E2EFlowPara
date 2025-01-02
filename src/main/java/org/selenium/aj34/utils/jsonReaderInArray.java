package org.selenium.aj34.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jsonReaderInArray {
    public static List<Map<String, String>> getJsonData(String fileName) {
        File srcFile = new File(System.getProperty("user.dir") +
                "\\src\\test\\resources\\TestData\\" + fileName);
        JSONParser parser = new JSONParser();
        List<Map<String, String>> dataList = new ArrayList<>();

        try {
            JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));
            for (Object jsonObj : jArray) {
                JSONObject person = (JSONObject) jsonObj;
                Map<String, String> dataMap = new HashMap<>();
                for (Object key : person.keySet()) {
                    dataMap.put(key.toString(), person.get(key).toString());
                }
                dataList.add(dataMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public static String getJsonValue(String obj, String fileNme) {
        File srcFile = new File(System.getProperty("user.dir") +
                "\\src\\test\\resources\\TestData\\" + fileNme);
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
