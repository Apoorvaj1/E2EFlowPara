package Tests;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ProductTest_SearchBox extends BaseTest {

    PageObjects.HomePage homePage;
    PageObjects.ProductPage productPage;
    @Test
    public void searchProductBySearchBox(){
        homePage = new HomePage(driver);
        homePage.click_product();
        productPage = new ProductPage(driver);
        productPage.enterProductInSearchBox(org.selenium.aj34.utils.configReader.readKey("productName"));
        productPage.clickSearchIcon();
        productPage.isSearchProductTextVisible();
    }
}
