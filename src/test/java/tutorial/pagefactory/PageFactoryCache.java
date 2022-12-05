package tutorial.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageFactoryCache {

    @CacheLookup
    @FindBy(name = "q")
    private WebElement searchField;

    @CacheLookup
    @FindBy(xpath = "//button[@id='L2AGLb']")
    private WebElement acceptAll;

    private WebDriver driver;

    public PageFactoryCache(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public void clearAndSendText12Times(String text){
        waitForElemnt(acceptAll);
        acceptAll.click();
        long startTime = System.currentTimeMillis();
        waitForElemnt(searchField);
        for(int i = 0; i < 12; i++){
            searchField.clear();
            searchField.sendKeys(text);
        }
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("Time used in the execution is: " +diff);
    }

    private void waitForElemnt(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
