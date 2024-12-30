package PageObjects;

import commonForAll.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ProductPage extends BaseClass {
    public ProductPage(WebDriver driver){
        super(driver);
    }

    By allProductText = By.xpath("//h2[@class=\"title text-center\"][text()=\"All Products\"]");

    public boolean allProduct(){
        return driver.findElement(allProductText).isDisplayed();
    }

    By addToCartLink = By.xpath("(//div[@class=\"productinfo text-center\"]/p[text()=\"Blue Top\"]//parent::div//parent::div//parent::div/a[text()=\"Add to cart\"])[1]");

    public void click_ViewProduct() throws InterruptedException {
        driver.findElement(with(By.tagName("a")).below(driver.findElement(addToCartLink))).click();
        Thread.sleep(2000);
    }

    public void scrollToViewProduct(){
        scrollToWebElement(driver.findElement(addToCartLink));
    }


}
