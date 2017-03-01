package PageObjectModel;

import Tools.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class MortgagesPage extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[text()='Calculate your payments']")
    private WebElement calculateYourPaymentsButton;

    public MortgagesPage(WebDriver driver){
        super();
    }


    @Step
    public MortgagePaymentCalculatorPage clickOnCalculateYourPaymentsButton(){
        AbstractPage.clickOnWebelement(calculateYourPaymentsButton);
        return new MortgagePaymentCalculatorPage(driver);
    }
}