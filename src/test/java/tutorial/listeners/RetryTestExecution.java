package tutorial.listeners;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import utils.ConfigProperty;
import utils.ReadProperty;

public class RetryTestExecution implements IRetryAnalyzer {

    int counter = 1;
    int limit = 3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (ReadProperty.getRetryOption(ConfigProperty.RETRYFAILEDTETS).equalsIgnoreCase("yes") && counter < limit ){
            counter ++;
            return true;
        }
        return false;
    }

    @Test(retryAnalyzer = RetryTestExecution.class)
    public void test1(){
        System.out.println("running test1 on Annotationtransformer");
        Assert.assertTrue(false);
    }
    @Test
    public void test2(){
        System.out.println("running test2 on Annotationtransformer");
    }
    @Test
    public void test3(){
        System.out.println("running test3 on Annotationtransformer");
    }
}
