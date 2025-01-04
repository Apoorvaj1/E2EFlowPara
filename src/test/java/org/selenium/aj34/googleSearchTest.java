package org.selenium.aj34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class googleSearchTest {
    @Test

    public void test(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com");
        WebElement ele = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        driver.navigate().refresh();
        ele = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        ele.sendKeys("Hello");
    }

}
