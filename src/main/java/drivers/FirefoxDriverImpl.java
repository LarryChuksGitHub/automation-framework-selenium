package drivers;

import constants.FrameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class FirefoxDriverImpl implements IBrowserDriver {


    @Override
    public RemoteWebDriver getDriver() {
        //FrameworkConstants.setFirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
