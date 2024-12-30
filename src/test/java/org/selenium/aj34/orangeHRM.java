package org.selenium.aj34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class orangeHRM {


    WebDriver driver;
    @Test(dataProvider = "demoData",dataProviderClass = org.selenium.aj34.utils.excelReader.class)
    public void test(String username,String no,String password){
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().deleteAllCookies();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
            driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
            driver.findElement(By.xpath("//button[starts-with(@class,\"oxd-button\")]")).click();
    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
