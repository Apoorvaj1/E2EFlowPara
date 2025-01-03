package Tests;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import net.datafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class LoginTestInvalidCred extends BaseTest {

    LoginPage loginPage;

    HomePage homepage;

    Faker faker = new Faker();
    private static final Logger logger = LogManager.getLogger(LoginTestInvalidCred.class);

    @Test(groups = {"Regression"})
    public void login(){
        logger.info("--------------Started-------------------");
        homepage = new HomePage(driver);
        homepage.click_SignUpLogin();
        loginPage = new LoginPage(driver);
        loginPage.enterLoginEmail(faker.internet().emailAddress());
        loginPage.enterLoginPassword(org.selenium.aj34.utils.configReader.readKey("password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"Your email or password is incorrect!\"]")).isDisplayed());
        logger.info("--------------FINISHED-------------------");
    }
}
