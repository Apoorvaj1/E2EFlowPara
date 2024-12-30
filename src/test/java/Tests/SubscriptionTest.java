package Tests;

import PageObjects.HomePage;
import org.testng.annotations.Test;
import utils.BaseTest;

public class SubscriptionTest extends BaseTest {

    PageObjects.HomePage homePage;
    @Test
    public void subscription() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.enterSubscriptionEmail(RegisterTest.emailAddress);
    }
}
