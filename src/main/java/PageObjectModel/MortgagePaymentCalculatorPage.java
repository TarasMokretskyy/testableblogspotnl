package PageObjectModel;

import Tools.AbstractPage;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class MortgagePaymentCalculatorPage extends AbstractPage {

    private WebDriver driver;

    private String expectedWeeklyPayments;

    private String interestRate5Persents = "5";


    @FindBy(xpath = ".//*[@id='form_calculateur_versements']/div[2]/div/div[2]/div/div[1]/div[9]")
    private WebElement slider;

    @FindBy(css = "*#PrixProprietePlus")
    private WebElement purchasePricePlusButton;

    @FindBy(css = "*#MiseDeFondPlus")
    private WebElement downPaymentPlusButton;

    @FindBy(css = "*#Amortissement")
    private WebElement amortizationDropdawnMenu;

    @FindBy(css = "*#FrequenceVersement")
    private WebElement paymentFrequencyDropdawnMenu;

    @FindBy(css = "*#TauxInteret")
    private WebElement interestRateField;

    @FindBy(css = "*[id='calculateur'] *[id='btn_calculer']")
    private WebElement calculateButton;

    @FindBy(css = "*#paiement-resultats")
    private WebElement weeklyPayments;


    public MortgagePaymentCalculatorPage(WebDriver driver){
        super();
    }


    @Step
    public void moveSlider(){
        int sliderPoints = 20;
        AbstractPage.moveSlider(slider, sliderPoints);
    }


    @Step
    public void clickOnPurchasePricePlusButton(){
        //AbstractPage.clickOnWebelement(purchasePricePlusButton);
        //AbstractPage.clickOnWebelement(purchasePricePlusButton);
        AbstractPage.doubleClickOnWebelement(purchasePricePlusButton);
    }


    @Step
    public void clickOnDownPaymentPlusButton(){
        AbstractPage.clickOnWebelement(downPaymentPlusButton);
    }


    @Step
    public void select15YearsFromAmortizationDropdawnMenu(){
        Select select = new Select(amortizationDropdawnMenu);
        select.selectByVisibleText("15 years");
    }


    @Step
    public void selectWeeklyFromPaymentFrequencyDropdawnMenu(){
        Select select = new Select(paymentFrequencyDropdawnMenu);
        select.selectByVisibleText("weekly");
    }


    @Step
    public void inputTextIntoInterestRateField(){
        AbstractPage.inputTextIntoWebelement(interestRateField, interestRate5Persents);
    }


    @Step
    public MortgagePaymentCalculatorPage clickOnCalculateButton(){
        AbstractPage.clickOnWebelement(calculateButton);
        return new MortgagePaymentCalculatorPage(Browser.getDriver());
    }


    @Step
    public String getActualWeeklyPayments(){
        AbstractPage.waitForWebelement(weeklyPayments);
        String  result = weeklyPayments.getText();
        return result;
    }


    public void setExpectedWeeklyPayments(){
        expectedWeeklyPayments = "$ 836.75";
    }


    public String getExpectedWeeklyPayments(){
        return expectedWeeklyPayments;
    }
}