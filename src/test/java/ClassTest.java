import PageObjectModel.*;
import Tools.IwebApp;
import Tools.IwebAppTest;
import Tools.TestListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;


@Listeners(TestListenerClass.class)
public class ClassTest implements IwebAppTest {

    private Browser browser = new Browser(Browser.getDriver());
    private MainPage mainPage;
    private LoansMenu loansMenu;
    private MortgagesPage mortgagesPage;
    private MortgagePaymentCalculatorPage mortgagePaymentCalculatorPage;


    @BeforeClass
    public void setUp() {
        browser.openChromeBrowser();
        mainPage = browser.openMainPage();
    }


    @Test
    @Description(value = "Open mortgages webpage, set all necessary values, compare actual and expected results")
    public void Test() throws InterruptedException {
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
    public void tearDown() {
        Browser.closeBrowser();
    }


    @Override
    public IwebApp getTestedInstance() {
        return browser;
    }
}