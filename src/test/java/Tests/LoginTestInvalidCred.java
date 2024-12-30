package Tests;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class LoginTestInvalidCred extends BaseTest {

    LoginPage loginPage;

    HomePage homepage;

    Faker faker = new Faker();

    @Test
    public void login(){
        homepage = new HomePage(driver);
        homepage.click_SignUpLogin();
        loginPage = new LoginPage(driver);
        loginPage.enterLoginEmail(faker.internet().emailAddress());
        loginPage.enterLoginPassword(org.selenium.aj34.utils.configReader.readKey("password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"Your email or password is incorrect!\"]")).isDisplayed());
    }
}
