package tutorial.docker;

import com.google.common.util.concurrent.Uninterruptibles;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DockerRunner {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(Browser.CHROME.browserName());
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        driver.get("https://www.google.com/");
        String result = driver.getTitle();
        Assertions.assertThat(result).isEqualToIgnoringCase("Google");
        System.out.println(result);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        driver.quit();
    }
}
