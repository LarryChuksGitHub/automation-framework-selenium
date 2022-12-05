package tutorial.listeners;

import org.testng.annotations.*;

public class TestRunner {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("running Before Suite on TestRunner");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("running After Suite on TestRunner");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("running Before Method on TestRunner");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("running After Method on TestRunner");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("running Before Test on TestRunner");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("running After Test on TestRunner");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("running Before Class on TestRunner");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("running After Class on TestRunner");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("running Before Groups on TestRunner");
    }
    @AfterGroups
    public void afterGroups(){
        System.out.println("running After Groups on TestRunner");
    }


    @Test
    public void test1(){
        System.out.println("running test1 on TestRunner");
    }
    @Test
    public void test2(){
        System.out.println("running test2 on TestRunner");
    }
    @Test
    public void test3(){
        System.out.println("running test3 on TestRunner");
    }
}
