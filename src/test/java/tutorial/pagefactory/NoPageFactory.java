package tutorial.pagefactory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NoPageFactory {
    private By searchField = By.name("q");
    private By acceptAll = By.xpath("//button[@id='L2AGLb']");

    //private WebDriver driver;
   // RunPageFactoryTests runPageFactoryTests = new RunPageFactoryTests();

    public void clearAndSendText12Times(WebDriver driver, String text){
        WebElement element= driver.findElement(acceptAll);
        //Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        waitForElemnt(driver, element);
        element.click();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 12; i++){
            element = driver.findElement(searchField);
            waitForElemnt( driver, element);
            element.clear();
            element.sendKeys(text);
        }
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("Time used in the execution is: " +diff);
    }

    private void waitForElemnt(WebDriver driver, WebElement element) {
         new WebDriverWait(driver,Duration.ofSeconds(5))
        .pollingEvery(Duration.ofSeconds(1))
        .until(ExpectedConditions.visibilityOf(element));
        //.until(d-> d.findElement(searchField).isDisplayed());

    }
}
