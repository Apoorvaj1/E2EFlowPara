package org.selenium.aj34.utils;

import commonForAll.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class takingScreenshot {

    public static void screenshot(WebDriver driver,String folder) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File desc = new File(System.getProperty("user.dir")+"/src/test/resources/"+folder+"/"+System.currentTimeMillis()+".png");
        FileUtils.copyFile(src,desc);
    }
}
