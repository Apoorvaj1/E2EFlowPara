package PageObjects;

import commonForAll.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BaseClass {

    public PaymentPage(WebDriver driver){
        super(driver);
    }

    By nameOnCard = By.xpath("//input[@name=\"name_on_card\"]");
    By cardNumber = By.xpath("//input[@name=\"card_number\"]");
    By cvc = By.xpath("//input[@name=\"cvc\"]");
    By expiration = By.xpath("//input[@name=\"expiry_month\"]");
    By year = By.xpath("//input[@name=\"expiry_year\"]");
    By payAndConfirm = By.xpath("//button[@id=\"submit\"]");
    By confirmationText = By.xpath("//p[text()=\"Congratulations! Your order has been confirmed!\"]");

    public void enterCardName(String value){
        driver.findElement(nameOnCard).sendKeys(value);
    }
    public void enterCardNumber(String value){
        driver.findElement(cardNumber).sendKeys(value);
    }
    public void enterCVC(String value){
        driver.findElement(cvc).sendKeys(value);
    }
    public void enterExpiration(int value){
        driver.findElement(expiration).sendKeys(String.valueOf(value));
    }
    public void enterYear(int value){
        driver.findElement(year).sendKeys(String.valueOf(value));
    }

    public void clickPayAndConfirm(){
        driver.findElement(payAndConfirm).click();
    }

    public void confirmMessage(){
        driver.findElement(confirmationText).getText();
    }

}
