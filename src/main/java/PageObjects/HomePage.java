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

}
