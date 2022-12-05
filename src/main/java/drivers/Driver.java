package drivers;

import org.openqa.selenium.WebDriver;
import utils.ConfigProperty;
import utils.ReadProperty;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(String browser){
        return initDriver(browser);
    }

    private static WebDriver initDriver(String browser) {
           String propertyValue = ReadProperty.getPropertyValue(ConfigProperty.EXECUTIONENVIRONMENT);
        if (propertyValue.equalsIgnoreCase("local")) {
        if (browser.equalsIgnoreCase("chrome")) {
                if (isNull(BrowserDriverManager.getDriverThreadLocal())) {
                    driver = BrowserFactory.getConfigBrowser("chrome");
                    BrowserDriverManager.setDriverThreadLocal(driver);
                    return BrowserDriverManager.getDriverThreadLocal();
                     }
                }else if(browser.equalsIgnoreCase("firefox")){
                    if (isNull(BrowserDriverManager.getDriverThreadLocal())) {
                        driver = BrowserFactory.getConfigBrowser("firefox");
                        BrowserDriverManager.setDriverThreadLocal(driver);
                        BrowserDriverManager.setDriverThreadLocal(driver);
                         return BrowserDriverManager.getDriverThreadLocal();
                }
//            case "safariX":
//                if (isNull(BrowserDriverManager.getDriverThreadLocal())) {
//                    WebDriver driver = BrowserFactory.getConfigBrowser("safari");
//                    BrowserDriverManager.setDriverThreadLocal(driver);
//                    BrowserDriverManager.setDriverThreadLocal(driver);
//                    return BrowserDriverManager.getDriverThreadLocal();
//                    //}
//                }
        }
    }
        return BrowserDriverManager.getDriverThreadLocal();
    }

    public static void quitDriver(){
        if(nonNull(BrowserDriverManager.getDriverThreadLocal()) && nonNull(driver)){
            BrowserDriverManager.getDriverThreadLocal().close();
            driver.close();
            BrowserDriverManager.getDriverThreadLocal().quit();
            BrowserDriverManager.unloadDriverThreadLocal();
        }
    }

}
