package PageObjects;

import commonForAll.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends BaseClass {

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    By signUpName = By.xpath("//input[@name=\"name\"]");
    By signUpEmail = By.xpath("//input[@data-qa=\"signup-email\"]");

    By signUpButton = By.xpath("//button[text()=\"Signup\"]");
    By mrRadioButton = By.xpath("//input[@id=\"id_gender1\"]");
    By mrsRadioButton = By.xpath("//input[@id=\"id_gender2\"]");
    By passwordField = By.xpath("//input[@name=\"password\"]");
    By selectDay = By.xpath("//select[@id=\"days\"]");
    By selectMonth = By.xpath("//select[@id=\"months\"]");
    By selectYear = By.xpath("//select[@id=\"years\"]");
    By signUpNewsletter = By.xpath("//input[@name=\"newsletter\"]");
    By signUpSpecialOffer = By.xpath("//input[@name=\"optin\"]");

    By firstnameField = By.xpath("//input[@name=\"first_name\"]");
    By lastnameField = By.xpath("//input[@name=\"last_name\"]");
    By companyField = By.xpath("//input[@name=\"company\"]");
    By addressField = By.xpath("//input[@name=\"address1\"]");
    By stateField = By.xpath("//input[@name=\"state\"]");
    By cityField = By.xpath("//input[@name=\"city\"]");
    By zipcodeField = By.xpath("//input[@name=\"zipcode\"]");
    By phoneField = By.xpath("//input[@name=\"mobile_number\"]");
    By createAccountButton = By.xpath("//button[text()=\"Create Account\"]");

    By accountCreatedText = By.xpath("//h2[@class=\"title text-center\"]/b[text()=\"Account Created!\"]");
    By accountCreatedExtractText = By.xpath("//div[@class=\"col-sm-9 col-sm-offset-1\"]/p");
    By continueButton = By.xpath("//a[text()=\"Continue\"]");

    public void enterSignUpName(String name){
        driver.findElement(signUpName).sendKeys(name);
    }

    public void enterSignUpEmail(String email){
        driver.findElement(signUpEmail).sendKeys(email);
    }

    public void clickSignUpButton(){
        driver.findElement(signUpButton).click();
    }

    public void enterPassword(String value){
        driver.findElement(passwordField).sendKeys(value);
    }

    public void chooseDay(String value){
        selectValue(selectDay,value);
    }

    public void chooseMonth(String value){
        selectValue(selectMonth,value);
    }

    public void chooseYear(String value){
        selectValue(selectYear,value);
    }

    public void chooseEitherMrMrs(String value){
        if(value.equals("Mr.")){
            driver.findElement(mrRadioButton).click();
        }
        else if(value.equals("Mrs.")){
            driver.findElement(mrsRadioButton).click();
        }
    }

    public void signUpCheckboxes(){
        if(!driver.findElement(signUpNewsletter).isSelected()){
            driver.findElement(signUpNewsletter).click();
        }
        if (!driver.findElement(signUpSpecialOffer).isSelected()) {
            driver.findElement(signUpSpecialOffer).click();
        }
    }

    public void enterFirstName(String value){
        driver.findElement(firstnameField).sendKeys(value);
    }

    public void enterLastName(String value){
        driver.findElement(lastnameField).sendKeys(value);
    }

    public void enterCompany(String value){
        driver.findElement(companyField).sendKeys(value);
    }

    public void enterAddress(String value){
        driver.findElement(addressField).sendKeys(value);
    }

    public void enterState(String value){
        driver.findElement(stateField).sendKeys(value);
    }
    public void enterCity(String value){
        driver.findElement(cityField).sendKeys(value);
    }
    public void enterZipcode(String value){
        driver.findElement(zipcodeField).sendKeys(value);
    }
    public void enterPhone(String value){
        driver.findElement(phoneField).sendKeys(value);
    }

    public void clickCreateAccount(){
        driver.findElement(createAccountButton).click();
    }

    public boolean verifyAccountCreatedText(){
        return driver.findElement(accountCreatedText).isDisplayed();
    }

    public void allTextExtract(){
        List<WebElement> texts = driver.findElements(accountCreatedExtractText);
        for(WebElement text:texts){
            System.out.println(text.getText());
        }
    }
    public DashboardPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new DashboardPage(driver);
    }

}
