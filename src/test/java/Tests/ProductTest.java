package Tests;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ProductTest extends BaseTest {

    PageObjects.HomePage homePage;
    PageObjects.ProductPage productPage;
    @Test
    public void product() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.click_product();
        productPage = new ProductPage(driver);
        productPage.allProduct();
        productPage.scrollToViewProduct();
        productPage.click_ViewProduct();
        boolean isAvailable = productPage.verifyTextAvailable();
        Assert.assertTrue(isAvailable);
    }
}
