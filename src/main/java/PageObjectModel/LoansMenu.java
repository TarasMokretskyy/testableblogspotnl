package PageObjectModel;

import Tools.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoansMenu extends AbstractPage {

    private WebDriver driver;

    @FindBy(css = "*[href='/individuals/pret']")
    private WebElement loansMenu;

    @FindBy(css = "[data-utag-name='mortgage_loan']")
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