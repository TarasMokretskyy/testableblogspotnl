package Tools;


import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListenerClass extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result){
        IwebAppTest iwebAppTest = (IwebAppTest) result.getInstance();
        iwebAppTest.getTestedInstance().tekeScreenshot("Failure screenshot");
    }


    @Override
    public void onTestSuccess(ITestResult result){
        IwebAppTest iwebAppTest = (IwebAppTest) result.getInstance();
        iwebAppTest.getTestedInstance().tekeScreenshot("Success screenshot");
    }
}