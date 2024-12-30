package commonForAll;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor jse;
    protected Select select;
    protected BaseClass(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    protected void setElementText(By textElementText, String value) {
        WebElement element = driver.findElement(textElementText);
        element.sendKeys(value);
    }

    protected void clickOnButton(By button) {

        WebElement element = driver.findElement(button);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void clearElementText(By locator) {
        WebElement element = driver.findElement(locator);
        element.clear();
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> elementsList(By locator) {
        return driver.findElements(locator);
    }

//    protected void scrollToBottom() {
//        jse.executeScript("scrollBy(0,2500)");
//    }

    protected void selectValue(By ele,String value){
        select = new Select(driver.findElement(ele));
        select.selectByVisibleText(value);
    }

    public static void uploadFile() throws AWTException {
        StringSelection selection = new StringSelection(org.selenium.aj34.utils.configReader.readKey("file"));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_HOME);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_HOME);

        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(2000);

    }

    public void acceptPopup(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissPopup(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void enterDataPopup(String value){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }

    public void isAlertPresent(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void scrollToWebElement(WebElement ele){
        jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",ele);
    }

    public void scrollToBottom(){
        jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }



}
