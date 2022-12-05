package logintest;

import basetest.BaseTest;
import facade.LoginFacade;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import reports.ExtentReport;
import tutorial.listeners.RetryTestExecution;
import utils.ReadDataFromExcel;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public final class LoginTests extends BaseTest {

    private LoginTests(){}


   // @Test()
//    public void userLoginTest(){
//        String username = "tomsmith";
//        String password = "SuperSecretPassword!";
//        String result =
//                new LoginFacade().naviagteToLoginPageAndDoLogin(username,password);
//        //String text = "You logged into a secure area!";
//        String text = "This should fail the test";
//        Assertions.assertThat(result).contains(text).isNotNull().isNotEmpty().as("The result","You logged in");
//
//    }


//
//    @Test(dataProvider = "excelMapData", dataProviderClass = ReadDataFromExcel.class)
//    public void userLoginTest1(String username, String password, String browser){
//        String result =
//                new LoginFacade().naviagteToLoginPageAndDoLogin(username,password, browser);
//        Assertions.assertThat(result).contains("You logged into a secure area!").isNotNull().isNotEmpty().as("The result","You logged in");
//
//    }

//
    @Test(dataProvider = "excelMapData", dataProviderClass = ReadDataFromExcel.class)
    public void userLoginTest2(Map<String,String> map, Method method){
        String browser = map.get("browser");
        ExtentReport.getExtentTestPass(method.getName()+ " "+ browser).assignAuthor("Larry");
        Arrays.toString(map.keySet().toArray());
        String username = map.get("username");
        String password = map.get("password");

        System.out.println("DataProvider uesername: " + username);
        System.out.println("DataProvider browser: " + browser);
        String testName = method.getName() +" " +browser;
        String result =
                new LoginFacade().naviagteToLoginPageAndDoLogin(username,password, method.getName(), browser);
        Assertions.assertThat(result).contains("You logged into a secure area!").isNotNull().isNotEmpty().as("The result","You logged in");

    }
}
