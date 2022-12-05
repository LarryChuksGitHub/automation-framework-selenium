package basetest;

import drivers.Driver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ExtentReport;

import java.util.Map;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite(){
        ExtentReport.configureReport();
    }

    @AfterSuite
    public void afterSuite(){
        ExtentReport.publishReport();

       //System.out.println("Quiting driver");
        Driver.quitDriver();
    }

    @BeforeMethod
    public static void setUp(Object [] data){
        Map<String, String> map = (Map<String, String>) data [0];
        String browser = map.get("browser");
        Driver.getDriver(browser);

    }

    @AfterMethod
    public static void afterMethod(ITestResult result){
        if ( result.getStatus() == ITestResult.FAILURE){
           String testName = result.getName();
           String browserName = null;
           ExtentReport.getExtentTestFail(result.getThrowable().toString() +", Element was not found, so the test: " + testName+ " failed" ,browserName);
        }

    }

    @AfterTest
    public static void tearDown(){
        //ExtentReport.publishReport();
    }

}
