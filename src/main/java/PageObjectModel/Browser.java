package PageObjectModel;

import Tools.IwebApp;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class Browser implements IwebApp {

    private static WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }


    @Step
    public static WebDriver openChromeBrowser() {
        String exePath = "C:\\Users\\1\\IntelliJ IDEA 2016.3.4\\Drivers\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }


    @Step
    public static MainPage openMainPage(){
        driver.get("http://ia.ca/");
        return new MainPage();
    }


    public static WebDriver getDriver() {
        return driver;
    }



    public static void closeBrowser(){
        driver.quit();
        driver = null;
    }


    @Override
    @Attachment
    public byte[] tekeScreenshot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }
}