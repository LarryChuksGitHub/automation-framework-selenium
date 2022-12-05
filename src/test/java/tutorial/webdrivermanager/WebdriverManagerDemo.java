package tutorial.webdrivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverManagerDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriver webDriver = new ChromeDriver();
    }
}
