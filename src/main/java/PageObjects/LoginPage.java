package PageObjects;

import commonForAll.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    By loginEmailField = By.xpath("//input[@data-qa=\"login-email\"]");
    By loginPasswordField = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButtonField = By.xpath("//button[@data-qa=\"login-button\"]");

    public void enterLoginEmail(String value){
        driver.findElement(loginEmailField).sendKeys(value);
    }
    public void enterLoginPassword(String value){
        driver.findElement(loginPasswordField).sendKeys(value);
    }
    public void clickLoginButton(){
        driver.findElement(loginButtonField).click();
    }
}
