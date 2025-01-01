package PageObjects;

import commonForAll.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ProductPage extends BaseClass {
    public ProductPage(WebDriver driver){
        super(driver);
    }

    By allProductText = By.xpath("//h2[@class=\"title text-center\"][text()=\"All Products\"]");

    public boolean allProduct(){
        return driver.findElement(allProductText).isDisplayed();
    }

    By addToCartLink = By.xpath("(//div[@class=\"productinfo text-center\"]/p[text()=\""+org.selenium.aj34.utils.configReader.readKey("productName")+"\"]//parent::div//parent::div//parent::div/a[text()=\"Add to cart\"])[1]");
    By productText = By.xpath("//h2[text()=\""+org.selenium.aj34.utils.configReader.readKey("productName")+"\"]");
    By searchBoxField = By.xpath("//input[@id=\"search_product\"]");
    By searchIcon = By.xpath("//button[@id=\"submit_search\"]");
    By searchProductText = By.xpath("//h2[@class=\"title text-center\"][text()=\"Searched Products\"]");
    By product1 = By.xpath("(//div[@class=\"productinfo text-center\"]/p[text()=\""+org.selenium.aj34.utils.configReader.readKey("anotherProduct")+"\"]//parent::div//parent::div//parent::div/a[text()=\"Add to cart\"])[1]");
    By successMessage = By.xpath("//p[text()=\"Your product has been added to cart.\"]");
    By continueShopping = By.xpath("//button[text()=\"Continue Shopping\"]");
    By totalProductInCart = By.xpath("//tr[contains(@id,\"product\")]/td/following-sibling::td/h4/a");
    By proceedToCheckout = By.xpath("//a[text()=\"Proceed To Checkout\"]");
    By registerLoginLink = By.xpath("//a/u[text()=\"Register / Login\"]");
    By placeOrder = By.xpath("//a[text()=\"Place Order\"]");

    public void click_ViewProduct() throws InterruptedException {
        driver.findElement(with(By.tagName("a")).below(driver.findElement(addToCartLink))).click();
        Thread.sleep(2000);
    }

    public void scrollToViewProduct(){
        scrollToWebElement(driver.findElement(addToCartLink));
    }

    public boolean verifyTextAvailable(){
        return driver.findElement(productText).isDisplayed();
    }

    public void enterProductInSearchBox(String value){
        driver.findElement(searchBoxField).sendKeys(value);
    }

    public void clickSearchIcon(){
        driver.findElement(searchIcon).click();
    }

    public void isSearchProductTextVisible(){
        scrollToWebElement(driver.findElement(searchProductText));
        boolean bool = driver.findElement(searchProductText).isDisplayed();
        if(bool){
            String productName = driver.findElement(By.xpath("//div[@class=\"productinfo text-center\"]/p")).getText();
            System.out.println("Product name is: "+productName);
        }
    }

    public void selectProduct() throws InterruptedException {
        scrollToWebElement(driver.findElement(product1));
        driver.findElement(product1).click();
        Thread.sleep(2000);
        verifyPresenceOfElement(successMessage);
        driver.findElement(continueShopping).click();
        Thread.sleep(2000);
        scrollToWebElement(driver.findElement(addToCartLink));
        driver.findElement(addToCartLink).click();
        Thread.sleep(2000);
        verifyPresenceOfElement(successMessage);
        driver.findElement(continueShopping).click();
        Thread.sleep(2000);
        scrollToWebElement(driver.findElement(By.xpath(" (//ul[@class=\"nav navbar-nav\"]/li/a[normalize-space()=\"Cart\"])")));
        driver.findElement(By.xpath(" (//ul[@class=\"nav navbar-nav\"]/li/a[normalize-space()=\"Cart\"])")).click();
        List<WebElement> list = driver.findElements(totalProductInCart);
        for(WebElement ele:list){
            System.out.println(ele.getText());
        }

    }

    public PaymentPage checkoutAfterLogin(){
        driver.findElement(proceedToCheckout).click();
        scrollToWebElement(driver.findElement(placeOrder));
        driver.findElement(placeOrder).click();
        return new PaymentPage(driver);
    }

    public void checkout(){
        driver.findElement(proceedToCheckout).click();
        driver.findElement(registerLoginLink).click();
    }

    public void checkout1(){
        driver.findElement(proceedToCheckout).click();
    }

    public void scrollToPlaceOrder(){
        scrollToWebElement(driver.findElement(placeOrder));
        driver.findElement(placeOrder).click();
    }


}
