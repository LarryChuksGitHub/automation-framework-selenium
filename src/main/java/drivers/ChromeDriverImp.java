package drivers;

import constants.FrameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class ChromeDriverImp implements IBrowserDriver {
    @Override
    public RemoteWebDriver getDriver() {
        //FrameworkConstants.setChromeDriver();
        //return new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
