package Tests;

import PageObjects.DashboardPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.BaseTest;

public class LogoutTest extends BaseTest {

    PageObjects.HomePage homePage;
    PageObjects.LoginPage loginPage;
    PageObjects.DashboardPage dashboardPage;
    private static final Logger logger = LogManager.getLogger(LogoutTest.class);
    @Test
    public void login(){
        logger.info("--------------Started-------------------");
        homePage = new HomePage(driver);
        homePage.click_SignUpLogin();
        loginPage = new LoginPage(driver);
        loginPage.enterLoginEmail(RegisterTest.emailAddress);
        loginPage.enterLoginPassword(org.selenium.aj34.utils.configReader.readKey("password"));
        loginPage.clickLoginButton();
        dashboardPage = new DashboardPage(driver);
        loginPage = dashboardPage.clickLogout();
        System.out.println("Able to navigate back to login page");
        logger.info("--------------FINISHED-------------------");
    }

}
