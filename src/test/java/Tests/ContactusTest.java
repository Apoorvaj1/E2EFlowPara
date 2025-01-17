package Tests;

import PageObjects.ContactUsPage;
import PageObjects.HomePage;
import commonForAll.BaseClass;
import net.datafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.awt.*;

public class ContactusTest extends BaseTest {

    PageObjects.HomePage homePage;
    PageObjects.ContactUsPage contactUsPage;

    Faker faker = new Faker();
    private static final Logger logger = LogManager.getLogger(ContactusTest.class);
    @Test
    public void contactDetails() throws AWTException, InterruptedException {
        logger.info("--------------Started-------------------");
        homePage = new HomePage(org.selenium.aj34.utils.browserFactory.getDriver());
        homePage.click_contactUs();
        contactUsPage = new ContactUsPage(org.selenium.aj34.utils.browserFactory.getDriver());
        contactUsPage.enterName(RegisterTest.firstName);
        contactUsPage.enterEmail(RegisterTest.emailAddress);
        contactUsPage.enterSubject(faker.educator().course());
        contactUsPage.enterMessage(faker.lorem().sentence(200));
        contactUsPage.chooseFile();
        contactUsPage.clickSubmit();
        contactUsPage.acceptPopUP();
        String message = contactUsPage.confirmMessage();
        Assert.assertEquals(message,"Success! Your details have been submitted successfully.");
        Thread.sleep(2000);
        logger.info("--------------FINISHED-------------------");
    }
}
