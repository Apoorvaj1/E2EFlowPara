package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

//    public WebDriver init(String browserName){
//        switch (browserName.toLowerCase()){
//            case "edge":
//                EdgeOptions options = new EdgeOptions();
//                options.addArguments("disable-notifications");
//                options.addArguments("--disable-popup-blocking");
//                driver = new EdgeDriver(options);
//                break;
//
//            case "chrome":
//                ChromeOptions option1 = new ChromeOptions();
//                option1.addArguments("disable-notifications");
//                option1.addArguments("--disable-popup-blocking");
//                driver = new ChromeDriver(option1);
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported browser: " + browserName);
//        }
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().deleteAllCookies();
//        return driver;
//    }

    @BeforeClass
    public void initializeBrowser(){
        String browserName = org.selenium.aj34.utils.configReader.readKey("browser");
        WebDriver driver;
        switch (browserName.toLowerCase()){
            case "edge":
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-popup-blocking");
                driver = new EdgeDriver(options);
                break;

            case "chrome":
                ChromeOptions options1 = new ChromeOptions();
                options1.addArguments("--disable-notifications");
                options1.addArguments("--disable-popup-blocking");
                driver = new ChromeDriver(options1);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        org.selenium.aj34.utils.browserFactory.setDriver(driver); // Set ThreadLocal driver
        org.selenium.aj34.utils.browserFactory.getDriver().get(org.selenium.aj34.utils.configReader.readKey("homepage(URL)"));
    }

//    @BeforeClass(alwaysRun = true)
//    public void initializeBrowser(){
//        driver = init(org.selenium.aj34.utils.configReader.readKey("browser"));
//        org.selenium.aj34.utils.browserFactory.setDriver(driver);
//        driver = org.selenium.aj34.utils.browserFactory.getDriver();
//        driver.get(org.selenium.aj34.utils.configReader.readKey("homepage(URL)"));
//    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        if(org.selenium.aj34.utils.browserFactory.getDriver()!=null){
            org.selenium.aj34.utils.browserFactory.getDriver().quit();
            org.selenium.aj34.utils.browserFactory.unload();
        }
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            org.selenium.aj34.utils.takingScreenshot.screenshot(org.selenium.aj34.utils.browserFactory.getDriver(),"screenshots");
        }
    }
}
