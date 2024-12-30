package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    public WebDriver init(String browserName){
        switch (browserName.toLowerCase()){
            case "edge":
                driver = new EdgeDriver();
                break;

            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        return driver;
    }

    @BeforeClass
    public void initializeBrowser(){
        driver = init(org.selenium.aj34.utils.configReader.readKey("browser"));
        org.selenium.aj34.utils.browserFactory.setDriver(driver);
        driver.get(org.selenium.aj34.utils.configReader.readKey("homepage(URL)"));
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
