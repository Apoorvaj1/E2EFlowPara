package Tests;

import PageObjects.ContactUsPage;
import PageObjects.HomePage;
import net.datafaker.Faker;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.awt.*;

public class ContactusTest extends BaseTest {

    PageObjects.HomePage homePage;
    PageObjects.ContactUsPage contactUsPage;
    Faker faker = new Faker();
    @Test
    public void contactDetails() throws AWTException {
        homePage = new HomePage(driver);
        homePage.click_contactUs();
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.enterName(RegisterTest.firstName);
        contactUsPage.enterEmail(RegisterTest.emailAddress);
        contactUsPage.enterSubject(faker.educator().course());
        contactUsPage.enterMessage(faker.lorem().sentence(200));
        contactUsPage.chooseFile();

    }
}
