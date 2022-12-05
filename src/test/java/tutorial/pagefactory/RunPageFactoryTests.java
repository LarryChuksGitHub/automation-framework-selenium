package tutorial.pagefactory;

import constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunPageFactoryTests {


    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        FrameworkConstants.setChromeDriver();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
        driver = null;
    }
    @Test
    public void FactoryDemoTest() throws InterruptedException { //3787 5441 3441
        PageFactoryDemo pageFactoryDemo = new PageFactoryDemo(driver);
        pageFactoryDemo.clearAndSendText12Times("Auf PostIdent ITU gibts Certificate Pinning, daher wird PostIdent Verfahren mit Charles wird blockiert");
    }

    @Test
    public void FactoryCacheTest(){ //4769 4729
        PageFactoryCache pageFactoryCache = new PageFactoryCache(driver);
        pageFactoryCache.clearAndSendText12Times("Auf PostIdent ITU gibts Certificate Pinning, daher wird PostIdent Verfahren mit Charles wird blockiert");
    }

    @Test
    public void NoFactoryCacheTest(){//4678 4636
        NoPageFactory noPageFactory = new NoPageFactory();
        noPageFactory.clearAndSendText12Times(driver,"Auf PostIdent ITU gibts Certificate Pinning, daher wird PostIdent Verfahren mit Charles wird blockiert");
    }
}
