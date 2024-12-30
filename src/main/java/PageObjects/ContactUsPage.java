package PageObjects;

import commonForAll.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class ContactUsPage extends BaseClass {

    public ContactUsPage(WebDriver driver){
        super(driver);
    }

    By nameField = By.xpath("//input[@data-qa=\"name\"]");
    By emailField = By.xpath("//input[@data-qa=\"email\"]");
    By subjectField = By.xpath("//input[@data-qa=\"subject\"]");
    By messageField = By.xpath("//textarea[@data-qa=\"message\"]");
    By uploadButton = By.xpath("//input[@name=\"upload_file\"]");
    By submitButton = By.xpath("//input[@data-qa=\"submit-button\"]");

    By confirmationMessage = By.xpath("//div[@class=\"status alert alert-success\"]");

    public void enterName(String value){
        driver.findElement(nameField).sendKeys(value);
    }

    public void enterEmail(String value){
        driver.findElement(emailField).sendKeys(value);
    }

    public void enterSubject(String value){
        driver.findElement(subjectField).sendKeys(value);
    }

    public void enterMessage(String value){
        driver.findElement(messageField).sendKeys(value);
    }


    public void clickSubmit() throws InterruptedException {
        driver.findElement(submitButton).click();
        Thread.sleep(2000);
        isAlertPresent();
        Thread.sleep(2000);
    }

    public void chooseFile() throws AWTException, InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(uploadButton)).click().perform();
        Thread.sleep(2000);
        uploadFile();
    }

    public void acceptPopUP(){
        acceptPopup();
    }

    public String confirmMessage(){
        return driver.findElement(confirmationMessage).getText();
    }
}
