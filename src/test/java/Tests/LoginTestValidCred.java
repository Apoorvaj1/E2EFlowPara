package Tests;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.BaseTest;

public class LoginTestValidCred extends BaseTest {

    PageObjects.LoginPage loginPage;

    HomePage homepage;
    private static final Logger logger = LogManager.getLogger(LoginTestValidCred.class);

    @Test(groups = {"Regression"})
    public void login(){
        logger.info("--------------Started-------------------");
        homepage = new HomePage(org.selenium.aj34.utils.browserFactory.getDriver());
        homepage.click_SignUpLogin();
        loginPage = new LoginPage(org.selenium.aj34.utils.browserFactory.getDriver());
        loginPage.enterLoginEmail(RegisterTest.emailAddress);
        loginPage.enterLoginPassword(org.selenium.aj34.utils.configReader.readKey("password"));
        loginPage.clickLoginButton();
        logger.info("--------------FINISHED-------------------");
    }
}
