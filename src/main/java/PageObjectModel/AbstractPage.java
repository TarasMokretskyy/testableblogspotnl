package PageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {


    public AbstractPage(){
        PageFactory.initElements(Browser.getDriver(), this);
    }


    public static void clickOnWebelement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public static void inputTextIntoWebelement(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(element));
        elem.clear();
        elem.sendKeys(text);
        elem.submit();
    }


    public static void waitForWebelement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void moveSlider(WebElement element, int sliderPoints) {
        Actions actions = new Actions(Browser.getDriver());
        actions.dragAndDropBy(element, sliderPoints, 0).build().perform();
    }


    public static void moveSlider(WebElement element, WebElement otherElement) {
        Actions actions = new Actions(Browser.getDriver());
        actions.clickAndHold(element).moveToElement(otherElement).release(otherElement).build();
    }
}