package org.selenium.aj34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class googleTest {
    WebDriver driver;

    //@Test(dataProvider = "demoData",dataProviderClass = dataProvider.class)
//    @Test(dataProvider = "demoData",dataProviderClass = excelReader.class)
    @Test
    public void test(){   //String searchText
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com");
        //driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]")).sendKeys(Data.configReader.readKey("place"),Keys.ENTER);
        //driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]")).sendKeys(Data.jsonReaderInArray.getJsonValue("place","abc.json"),Keys.ENTER);
        driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]")).sendKeys(org.selenium.aj34.utils.jsonReader.getJsonValue("place","abc1.json"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains(driver.getTitle()));
        System.out.println(driver.getTitle());

    }
    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
