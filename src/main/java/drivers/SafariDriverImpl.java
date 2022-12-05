package drivers;

import constants.FrameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class SafariDriverImpl implements IBrowserDriver{
    @Override
    public RemoteWebDriver getDriver() {
        //FrameworkConstants.setSafariDriver();
        WebDriverManager.safaridriver().setup();
        return new  SafariDriver();
    }
}
