package Tests;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ProductTest_SearchBox extends BaseTest {

    PageObjects.HomePage homePage;
    PageObjects.ProductPage productPage;
    private static final Logger logger = LogManager.getLogger(ProductTest_SearchBox.class);
    @Test
    public void searchProductBySearchBox(){
        logger.info("--------------Started-------------------");
        homePage = new HomePage(driver);
        homePage.click_product();
        productPage = new ProductPage(driver);
        productPage.enterProductInSearchBox(org.selenium.aj34.utils.configReader.readKey("productName"));
        productPage.clickSearchIcon();
        productPage.isSearchProductTextVisible();
        logger.info("--------------FINISHED-------------------");
    }
}
