package Tests;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.annotations.Test;
import utils.BaseTest;

public class LoginTestValidCred extends BaseTest {

    PageObjects.LoginPage loginPage;

    HomePage homepage;

    @Test
    public void login(){
        homepage = new HomePage(driver);
        homepage.click_SignUpLogin();
        loginPage = new LoginPage(driver);
        loginPage.enterLoginEmail(RegisterTest.emailAddress);
        loginPage.enterLoginPassword(org.selenium.aj34.utils.configReader.readKey("password"));
        loginPage.clickLoginButton();
    }
}
