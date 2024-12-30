package Tests;

import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class RegisterExistingUser extends BaseTest {

    PageObjects.RegisterPage registerPage;
    PageObjects.HomePage homePage;
    private static final Logger logger = LogManager.getLogger(RegisterExistingUser.class);

    @Test
    public void register(){
        logger.info("--------------Started-------------------");
        homePage = new HomePage(driver);
        homePage.click_SignUpLogin();
        registerPage = new RegisterPage(driver);
        registerPage.enterSignUpName(RegisterTest.firstName);
        registerPage.enterSignUpEmail(RegisterTest.emailAddress);
        registerPage.clickSignUpButton();
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"Email Address already exist!\"]")).isDisplayed());
        logger.info("--------------FINISHED-------------------");
    }
}
