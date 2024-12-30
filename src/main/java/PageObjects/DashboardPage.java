package PageObjects;

import commonForAll.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BaseClass {
    public DashboardPage(WebDriver driver){
        super(driver);
    }

    By deleteAccount = By.xpath("//ul[@class=\"nav navbar-nav\"]/li[normalize-space()=\"Delete Account\"]");
    By accountDeletedText = By.xpath("//h2[@class=\"title text-center\"]/b[text()=\"Account Deleted!\"]");
    By logout = By.xpath("//ul[@class=\"nav navbar-nav\"]/li/a[normalize-space()=\"Logout\"]");
    public void clickDeleteAccount(){
        driver.findElement(deleteAccount).click();
    }

    public LoginPage clickLogout(){
        driver.findElement(logout).click();
        return new LoginPage(driver);
    }

    public boolean deleteAccountOption(){
        return driver.findElement(deleteAccount).isDisplayed();
    }

    public boolean verifyAccountDeletedText(){
        return driver.findElement(accountDeletedText).isDisplayed();
    }
}
