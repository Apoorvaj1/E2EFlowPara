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

    By addToCartLink = By.xpath("(//div[@class=\"productinfo text-center\"]/p[text()=\""+org.selenium.aj34.utils.configReader.readKey("productName")+"\"]//parent::div//parent::div//parent::div/a[text()=\"Add to cart\"])[1]");
    By productText = By.xpath("//h2[text()=\""+org.selenium.aj34.utils.configReader.readKey("productName")+"\"]");
    By searchBoxField = By.xpath("//input[@id=\"search_product\"]");
    By searchIcon = By.xpath("//button[@id=\"submit_search\"]");
    By searchProductText = By.xpath("//h2[@class=\"title text-center\"][text()=\"Searched Products\"]");

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


}
