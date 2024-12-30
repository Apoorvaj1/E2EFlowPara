package PageObjects;

import commonForAll.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver){
        super(driver);
    }
    By signUpLoginButton = By.xpath("//ul[@class=\"nav navbar-nav\"]/li/a[normalize-space()=\"Signup / Login\"]");
    By contactUsButton = By.xpath("//ul[@class=\"nav navbar-nav\"]/li/a[normalize-space()=\"Contact us\"]");
    By productButton = By.xpath("//ul[@class=\"nav navbar-nav\"]/li[2]");
    By subscriptionBox = By.xpath("//input[@id=\"susbscribe_email\"]");
    By subscriptionClickIcon = By.xpath("//button[@id=\"subscribe\"]");
    By cartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]/li/a[normalize-space()=\"Cart\"]");

    public RegisterPage click_SignUpLogin(){
        driver.findElement(signUpLoginButton).click();
        return new RegisterPage(driver);
    }

    public void click_contactUs(){
        driver.findElement(contactUsButton).click();
    }

    public void click_product(){
        driver.findElement(productButton).click();
    }

    public void enterSubscriptionEmail(String value) throws InterruptedException {
        scrollToBottom();
        driver.findElement(subscriptionBox).sendKeys(value);
        driver.findElement(subscriptionClickIcon).click();
        Thread.sleep(2000);
    }

    public void clickCart(){
        driver.findElement(cartButton).click();
    }

}
