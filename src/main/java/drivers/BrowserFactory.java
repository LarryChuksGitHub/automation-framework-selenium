package drivers;

import constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.ConfigProperty;

public final class BrowserFactory {

    private BrowserFactory(){}

    private static WebDriver driver;

    public static WebDriver getConfigBrowser(String browser){
        if (browser.equalsIgnoreCase(ConfigProperty.CHROME.name())){
            FrameworkConstants.setChromeDriver();
            return driver = new ChromeDriverImp().getDriver();
        } else if(browser.equalsIgnoreCase(ConfigProperty.FIREFOX.name())){
            FrameworkConstants.setFirefoxDriver();
            return driver = new FirefoxDriverImpl().getDriver();
        }
        else if(browser.equalsIgnoreCase("safari")){
            FrameworkConstants.setSafariDriver();
            return driver = new SafariDriverImpl().getDriver();
        }

        return null;
    }
}
