package Tests;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ProductTest extends BaseTest {

    PageObjects.HomePage homePage;
    PageObjects.ProductPage productPage;
    PageObjects.LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(ProductTest.class);
    @Test
    public void product() throws InterruptedException {
        logger.info("--------------Started-------------------");
        homePage = new HomePage(org.selenium.aj34.utils.browserFactory.getDriver());
        homePage.click_product();
        productPage = new ProductPage(org.selenium.aj34.utils.browserFactory.getDriver());
        productPage.allProduct();
        productPage.scrollToViewProduct();
        productPage.click_ViewProduct();
        boolean isAvailable = productPage.verifyTextAvailable();
        Assert.assertTrue(isAvailable);
        logger.info("--------------FINISHED-------------------");
    }

    @Test
    public void addProductAndVerify() throws InterruptedException {
        homePage = new HomePage(org.selenium.aj34.utils.browserFactory.getDriver());
        homePage.click_product();
        productPage = new ProductPage(org.selenium.aj34.utils.browserFactory.getDriver());
        productPage.selectProduct();
    }

    @Test
    public void checkoutDetails(){
        productPage.checkout();
        loginPage = new LoginPage(org.selenium.aj34.utils.browserFactory.getDriver());
        loginPage.enterLoginEmail(RegisterTest.emailAddress);
        loginPage.enterLoginPassword(org.selenium.aj34.utils.configReader.readKey("password"));
        loginPage.clickLoginButton();

    }

    @Test
    public void placeOrder(){
        homePage = new HomePage(org.selenium.aj34.utils.browserFactory.getDriver());
        homePage.clickCart();
        productPage = new ProductPage(org.selenium.aj34.utils.browserFactory.getDriver());
        productPage.checkoutAfterLogin();
    }
}
