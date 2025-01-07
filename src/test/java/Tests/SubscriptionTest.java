package Tests;

import PageObjects.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.BaseTest;

public class SubscriptionTest extends BaseTest {

    PageObjects.HomePage homePage;
    private static final Logger logger = LogManager.getLogger(SubscriptionTest.class);
    @Test
    public void subscription() throws InterruptedException {
        logger.info("--------------Started-------------------");
        homePage = new HomePage(org.selenium.aj34.utils.browserFactory.getDriver());
        homePage.enterSubscriptionEmail(RegisterTest.emailAddress);
        logger.info("--------------FINISHED-------------------");
    }
}
