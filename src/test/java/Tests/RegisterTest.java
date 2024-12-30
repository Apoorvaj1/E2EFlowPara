package Tests;

import PageObjects.LoginPage;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.DashboardPage;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import utils.BaseTest;

public class RegisterTest extends BaseTest {

        RegisterPage page;
        HomePage homepage;
        DashboardPage dashboardPage;
        LoginPage loginPage;

        Faker faker = new Faker();
        public static String firstName = null;
        public static String emailAddress = null;

        @Test
        public void createUserAccount(){
           homepage = new HomePage(driver);
           homepage.click_SignUpLogin();
           page = new RegisterPage(driver);
           firstName = faker.name().firstName();
           System.out.println(firstName);
           page.enterSignUpName(firstName);
           emailAddress = faker.internet().emailAddress();
           System.out.println(emailAddress);
           page.enterSignUpEmail(emailAddress);
           page.clickSignUpButton();
           page.chooseEitherMrMrs(org.selenium.aj34.utils.configReader.readKey("title"));
           page.enterPassword(org.selenium.aj34.utils.configReader.readKey("password"));
           page.chooseDay(org.selenium.aj34.utils.configReader.readKey("day"));
           page.chooseMonth(org.selenium.aj34.utils.configReader.readKey("month"));
           page.chooseYear(org.selenium.aj34.utils.configReader.readKey("year"));
           page.signUpCheckboxes();
           page.enterFirstName(firstName);
           page.enterLastName(faker.name().lastName());
           page.enterCompany(faker.company().name());
           page.enterAddress(faker.address().secondaryAddress());
           page.enterState(faker.address().state());
           page.enterCity(faker.address().city());
           page.enterZipcode(faker.address().zipCode());
           page.enterPhone(faker.phoneNumber().cellPhone());
           page.clickCreateAccount();
           boolean bool = page.verifyAccountCreatedText();
           Assert.assertTrue(bool);
           page.allTextExtract();
           page.clickContinueButton();
           dashboardPage = new DashboardPage(driver);
           Assert.assertTrue(dashboardPage.deleteAccountOption());
           loginPage = dashboardPage.clickLogout();

        }
}
