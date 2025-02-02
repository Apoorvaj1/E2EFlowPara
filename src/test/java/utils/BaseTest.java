package utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    private static WebDriver driver;
    @Parameters({"os","browser"})
    @BeforeClass
    public void initializeBrowser(String os,String browser) throws MalformedURLException {
        //String browserName = org.selenium.aj34.utils.configReader.readKey("browser");
        String browserName = System.getProperty("whichBrowser","chrome");


        if(org.selenium.aj34.utils.configReader.readKey("execution_env").equalsIgnoreCase("remote")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //os
            if(os.equalsIgnoreCase("windows")){
                capabilities.setPlatform(Platform.WIN11);
            }
            else if (os.equalsIgnoreCase("mac")){
                capabilities.setPlatform(Platform.MAC);
            }
            else {
                System.out.println("No matching os");
                return;
            }

            //browser
            switch (browser.toLowerCase()){
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                default:
                    System.out.println("No matching browser");
                    return;
            }
           driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        }
        if(org.selenium.aj34.utils.configReader.readKey("execution_env").equalsIgnoreCase("local")){
            switch (browser.toLowerCase()){
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
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        org.selenium.aj34.utils.browserFactory.setDriver(driver); // Set ThreadLocal driver
        org.selenium.aj34.utils.browserFactory.getDriver().get(org.selenium.aj34.utils.configReader.readKey("homepage(URL)"));
    }

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
