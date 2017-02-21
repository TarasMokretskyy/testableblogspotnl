package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

    private static WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }


    public static WebDriver openChromeBrowser() {
        String exePath = "C:\\Users\\1\\IntelliJ IDEA 2016.3.4\\Drivers\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }


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
}