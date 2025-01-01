package Tests;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.PaymentPage;
import PageObjects.ProductPage;
import net.datafaker.Faker;
import org.testng.annotations.Test;
import utils.BaseTest;

public class PaymentTest extends BaseTest {

    PageObjects.PaymentPage paymentPage;
    PageObjects.HomePage homePage;
    PageObjects.LoginPage loginPage;
    PageObjects.ProductPage productPage;
    Faker faker = new Faker();
    @Test
    public void paymentDetails(){
        homePage = new HomePage(driver);
        homePage.click_SignUpLogin();
        loginPage = new LoginPage(driver);
        loginPage.enterLoginEmail(RegisterTest.emailAddress);
        loginPage.enterLoginPassword(org.selenium.aj34.utils.configReader.readKey("password"));
        loginPage.clickLoginButton();
        homePage.clickCart();
        productPage = new ProductPage(driver);
        productPage.checkout1();
        productPage.scrollToPlaceOrder();
        paymentPage = new PaymentPage(driver);
        paymentPage.enterCardName(faker.name().fullName());
        paymentPage.enterCardNumber(faker.finance().creditCard());
        paymentPage.enterCVC(faker.number().digits(3));
        paymentPage.enterExpiration(faker.number().numberBetween(1,13));
        paymentPage.enterYear(faker.number().numberBetween(2024,2033));
        paymentPage.clickPayAndConfirm();
        paymentPage.confirmMessage();
    }
}
