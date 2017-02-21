package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class MainPage extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@href='/individuals/pret'][@data-utag-name='loans']")
    private static WebElement loasMenu;

    public MainPage() {
        super();
    }


    @Step
    public LoansMenu clickOnLoans(){
        AbstractPage.clickOnWebelement(loasMenu);
        return new LoansMenu(Browser.getDriver());
    }
}