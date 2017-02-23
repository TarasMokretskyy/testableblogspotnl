import PageObjectModel.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener_Demo.ListenerTest.class)


public class TestClass {

    private MainPage mainPage;
    private LoansMenu loansMenu;
    private MortgagesPage mortgagesPage;
    private MortgagePaymentCalculatorPage mortgagePaymentCalculatorPage;


    @BeforeClass
    public void setUp(){
        Browser.openChromeBrowser();
        mainPage = Browser.openMainPage();
    }


    @Test()
    public void Test() throws InterruptedException{
        loansMenu = mainPage.clickOnLoans();
        mortgagesPage = loansMenu.clickOnMortgagesLink();

        mortgagePaymentCalculatorPage = mortgagesPage.clickOnCalculateYourPaymentsButton();

        mortgagePaymentCalculatorPage.moveSlider();

        mortgagePaymentCalculatorPage.clickOnPurchasePricePlusButton();
        mortgagePaymentCalculatorPage.clickOnDownPaymentPlusButton();
        mortgagePaymentCalculatorPage.select15YearsFromAmortizationDropdawnMenu();
        mortgagePaymentCalculatorPage.selectWeeklyFromPaymentFrequencyDropdawnMenu();
        mortgagePaymentCalculatorPage.inputTextIntoInterestRateField();
        mortgagePaymentCalculatorPage.clickOnCalculateButton();

        mortgagePaymentCalculatorPage.setExpectedWeeklyPayments();
        String actual = mortgagePaymentCalculatorPage.getActualWeeklyPayments();
        String expected = mortgagePaymentCalculatorPage.getExpectedWeeklyPayments();

        Assert.assertEquals(actual, expected);
    }


    @AfterClass
    public void tearDown(){
        Browser.closeBrowser();
    }
}