package tutorial.listeners;

import org.testng.*;
import reports.ExtentReport;

public class ListenerDemo implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        System.out.println("Started suite on ListenerDemo");
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
        System.out.println("Finished suite on ListenerDemo");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("Started Test (Test result) on ListenerDemo");
        //ITestResult.SUCCESS
        var temp = result.getStatus();
        if (temp == 1){
            System.out.println("Result was successful");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        ExtentReport.getExtentTestFail("Could not find the element");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }
}
