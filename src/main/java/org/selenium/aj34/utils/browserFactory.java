package org.selenium.aj34.utils;

import org.openqa.selenium.WebDriver;

public class browserFactory {

    private static ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        tl.set(driver);
    }

    public static WebDriver getDriver(){
        return tl.get();
    }

    public static void unload(){
        tl.remove();
    }
}
