package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoansMenu extends AbstractPage {

    private WebDriver driver;

    @FindBy(css = "*[href='/individuals/pret']")
    private WebElement loansMenu;

    @FindBy(css = "*[href='http://ia.ca/mortgage']")
    private WebElement mortgages;


    public LoansMenu(WebDriver driver) {
        super();
    }


    @Step
    public MortgagesPage clickOnMortgagesLink(){
        clickOnWebelement(mortgages);
        return new MortgagesPage(Browser.getDriver());
    }
}