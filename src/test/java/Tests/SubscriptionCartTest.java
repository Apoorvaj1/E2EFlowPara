package Tests;

import PageObjects.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.BaseTest;

public class SubscriptionCartTest extends BaseTest {

    PageObjects.HomePage homePage;
    private static final Logger logger = LogManager.getLogger(SubscriptionCartTest.class);
    @Test
    public void subscriptionInsideCart() throws InterruptedException {
        logger.info("--------------Started-------------------");
        homePage = new HomePage(driver);
        homePage.clickCart();
        homePage.enterSubscriptionEmail(RegisterTest.emailAddress);
        logger.info("--------------FINISHED-------------------");
    }
}
