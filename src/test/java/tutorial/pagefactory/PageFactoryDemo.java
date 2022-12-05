package tutorial.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageFactoryDemo {

    @FindBy(name="q")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='L2AGLb']")
    private WebElement acceptAll;

    private WebDriver driver;

    public PageFactoryDemo(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public void clearAndSendText12Times(String text) throws InterruptedException {
        waitForElemnt(acceptAll);
        acceptAll.click();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 12; i++){
            waitForElemnt(searchField);
            searchField.clear();
            searchField.sendKeys(text);
        }
        //searchField.sendKeys(text, Keys.ENTER);
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("Time used in the execution is: " +diff);
        //Thread.sleep(500000000);
    }

    private void waitForElemnt(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
