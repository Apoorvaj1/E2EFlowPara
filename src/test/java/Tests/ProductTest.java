package Tests;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ProductTest extends BaseTest {

    PageObjects.HomePage homePage;
    PageObjects.ProductPage productPage;
    private static final Logger logger = LogManager.getLogger(ProductTest.class);
    @Test
    public void product() throws InterruptedException {
        logger.info("--------------Started-------------------");
        homePage = new HomePage(driver);
        homePage.click_product();
        productPage = new ProductPage(driver);
        productPage.allProduct();
        productPage.scrollToViewProduct();
        productPage.click_ViewProduct();
        boolean isAvailable = productPage.verifyTextAvailable();
        Assert.assertTrue(isAvailable);
        logger.info("--------------FINISHED-------------------");
    }
}
