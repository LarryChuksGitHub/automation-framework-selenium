package pages.basepage;

import drivers.Driver;
import logger.ConsoleLogImpl;
import logger.FrameworkLogger;
import logger.LogType;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentReport;
import reports.ExtententReportManager;

import java.time.Duration;

public class BasePage {

    // locating elements
    //h3[text()='Testing Mini Bytes - YouTube’]   Xpath to find link in YouTube
    //div[text(()='login']/parent::a
    //input[@type='password' and @name='password' and @id='password']
    //cssSelector("input.gLFyf.gsfi");
    //1.id , 2.name, 3 classname, 4 linktext, 5 partiallinktext, 6 css 7 xpath
    // ^[a-z][a-zA-Z0-9]*$  // ^ starting, [a-z] anything between a to z,[a-zA-Z0-9] the remaing letter can be anything between a to z and A to Z and 0 to 9, * it can occure many times

    private WebDriver driver;
    private Duration waitDuration = Duration.ofSeconds(10);
    private Duration polingDuration = Duration.ofSeconds(1);

    protected void waitForElement(WebElement element, WaitStrategy waitStrategy, String browser){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(browser),waitDuration);
        highlightElement(Driver.getDriver(browser),element);
        switch (waitStrategy){
            case NONE -> System.out.println(element + " is already presence no need to wait");
            case VISIBLE ->
            wait.pollingEvery(polingDuration).withMessage("checking the presence of element every 1 min")
                    //.until(ExpectedConditions.elementToBeClickable(element))
                    .until(ExpectedConditions.visibilityOf(element));
            case CLICKABLE ->
                    wait.pollingEvery(polingDuration).withMessage("checking the presence of element every 1 min")
                            .until(ExpectedConditions.elementToBeClickable(element));
            case INVISIBLE ->
                    wait.pollingEvery(polingDuration).withMessage("checking the presence of element every 1 min")
                            .until(ExpectedConditions.invisibilityOf(element));
        }
    }

    protected void click(WebElement webElement, String elementName){
        waitForElement(webElement,WaitStrategy.CLICKABLE, "browser");
        elementName = webElement.getText() +" "+ webElement.getAttribute("name");
        webElement.click();
        //System.out.println(elementName + " was clicked");
        //ExtentReport.getExtentTestPass(elementName +" was clicked");
       // FrameworkLogger.log(LogType.PASS,elementName +" was clicked");
        //new ConsoleLogImpl().log("pass",elementName +" was clicked");
        FrameworkLogger.log(LogType.PASSCONSOLEANDEXTENT,elementName +" was clicked");
       // ExtententReportManager.getExtentThreadLocal().pass(elementName +" was clicked");
    }
    private void highlightElement(WebDriver webDriver, WebElement webElement){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid red'", webElement);
    }

    protected boolean isElementDisplayed(WebElement element, String browser){
        waitForElement(element,WaitStrategy.VISIBLE, browser);
        String elementName = element.getText();
        System.out.println(elementName + "is displyed");
        ExtentReport.getExtentTestInfo(elementName + "is displyed");
        FrameworkLogger.log(LogType.INFO,elementName + "is displyed");
     return true;
    }

    protected String getElementText(WebElement element, String browser){
        waitForElement(element,WaitStrategy.VISIBLE, browser);
        String elementName = element.getText();
        ExtentReport.getExtentTestInfo(elementName + " was displayed");
        return elementName;
    }

    protected void click(String locatorType, String locatorValue, String elementName, String browser){
        if(locatorType.equalsIgnoreCase("id")){
            click(Driver.getDriver(browser).findElement(By.id(locatorValue)),elementName);
        } else if (locatorType.equalsIgnoreCase("xpath")){
            click(Driver.getDriver(browser).findElement(By.xpath(locatorValue)),elementName);
        } else if (locatorType.equalsIgnoreCase("name")){
            click(Driver.getDriver(browser).findElement(By.name(locatorValue)),elementName);
        }else if(locatorType.equalsIgnoreCase("className")){
            click(Driver.getDriver(browser).findElement(By.className(locatorValue)),elementName);
        }
        else if(locatorType.equalsIgnoreCase("linktext")){
            click(Driver.getDriver(browser).findElement(By.linkText(locatorValue)),elementName);
        }
        else if(locatorType.equalsIgnoreCase("partialLinkText")){
            click(Driver.getDriver(browser).findElement(By.partialLinkText(locatorValue)),elementName);
        }
        else if(locatorType.equalsIgnoreCase("tagName")){
            click(Driver.getDriver(browser).findElement(By.tagName(locatorValue)),elementName);
        }
        else if(locatorType.equalsIgnoreCase("cssSelector")){
            click(Driver.getDriver(browser).findElement(By.cssSelector(locatorValue)),elementName);
        }
    }

    protected void click(String locatorType, By locatorValue, String elementName, String browser ){
        if(locatorType.equalsIgnoreCase("id")){
            click(Driver.getDriver(browser).findElement(locatorValue),elementName);
        } else if (locatorType.equalsIgnoreCase("xpath")){
            click(Driver.getDriver(browser).findElement(locatorValue),elementName);
        } else if (locatorType.equalsIgnoreCase("name")){
            click(Driver.getDriver(browser).findElement(locatorValue),elementName);
        }else if(locatorType.equalsIgnoreCase("className")){
            click(Driver.getDriver(browser).findElement(locatorValue),elementName);
        }
        else if(locatorType.equalsIgnoreCase("linktext")){
            click(Driver.getDriver(browser).findElement(locatorValue),elementName);
        }
        else if(locatorType.equalsIgnoreCase("partialLinkText")){
            click(Driver.getDriver(browser).findElement(locatorValue),elementName);
        }
        else if(locatorType.equalsIgnoreCase("tagName")){
            click(Driver.getDriver(browser).findElement(locatorValue),elementName);
        }
        else if(locatorType.equalsIgnoreCase("cssSelector")){
            click(Driver.getDriver(browser).findElement(locatorValue),elementName);
        }
    }

    public void click(String locatorType, String elementTextName, String browser){
        String text = "%s";
        elementTextName = String.format(text,elementTextName);
        if(locatorType.equalsIgnoreCase("linktext")){
            click(Driver.getDriver(browser).findElement(By.linkText(elementTextName)),elementTextName);
        }else if (locatorType.equalsIgnoreCase("id")){
            click(Driver.getDriver(browser).findElement(By.id(elementTextName)),elementTextName);
        }
        else if (locatorType.equalsIgnoreCase("xpath")){
            click(Driver.getDriver(browser).findElement(By.xpath(elementTextName)),elementTextName);
        }
        else if (locatorType.equalsIgnoreCase("name")){
            click(Driver.getDriver(browser).findElement(By.name(elementTextName)),elementTextName);
        }
        else if (locatorType.equalsIgnoreCase("cssSelector")){
            click(Driver.getDriver(browser).findElement(By.cssSelector(elementTextName)),elementTextName);
        }
        else if (locatorType.equalsIgnoreCase("className")){
            click(Driver.getDriver(browser).findElement(By.className(elementTextName)),elementTextName);
        }
        else if (locatorType.equalsIgnoreCase("tagName")){
            click(Driver.getDriver(browser).findElement(By.tagName(elementTextName)),elementTextName);
        }
        else if (locatorType.equalsIgnoreCase("partialLinkText")){
            click(Driver.getDriver(browser).findElement(By.partialLinkText(elementTextName)),elementTextName);
        }
    }

    protected void sendText(WebElement element, String text, String browser){
        waitForElement(element,WaitStrategy.NONE,browser);
        ExtentReport.getExtentTestInfo("sending " +text + " to " + element.getAttribute("name"));
        element.sendKeys(text);
    }

    protected void sendText(String locatorType, String locatorValue, String text, Keys enter, String browser){
        if(locatorType.equalsIgnoreCase("id")){
            sendText(Driver.getDriver(browser).findElement(By.id(locatorValue)),text,browser);
        } else if (locatorType.equalsIgnoreCase("xpath")){
            sendText(Driver.getDriver(browser).findElement(By.xpath(locatorValue)),text,browser);
        } else if (locatorType.equalsIgnoreCase("name")){
            sendText(Driver.getDriver(browser).findElement(By.name(locatorValue)),text,browser);
        }else if(locatorType.equalsIgnoreCase("className")){
            sendText(Driver.getDriver(browser).findElement(By.className(locatorValue)),text,browser);
        }
        else if(locatorType.equalsIgnoreCase("linktext")){
            sendText(Driver.getDriver(browser).findElement(By.linkText(locatorValue)),text,browser);
        }
        else if(locatorType.equalsIgnoreCase("partialLinkText")){
            sendText(Driver.getDriver(browser).findElement(By.partialLinkText(locatorValue)),text, browser);
        }
        else if(locatorType.equalsIgnoreCase("tagName")){
            sendText(Driver.getDriver(browser).findElement(By.tagName(locatorValue)),text,browser);
        }
        else if(locatorType.equalsIgnoreCase("cssSelector")){
            sendText(Driver.getDriver(browser).findElement(By.cssSelector(locatorValue)),text,browser);
        }
    }

    protected void sendText(String locatorType, String locatorValue, String text, String browser){
        if(locatorType.equalsIgnoreCase("id")){
            sendText(Driver.getDriver(browser).findElement(By.id(locatorValue)),text, browser);
        } else if (locatorType.equalsIgnoreCase("xpath")){
            sendText(Driver.getDriver(browser).findElement(By.xpath(locatorValue)),text, browser);
        } else if (locatorType.equalsIgnoreCase("name")){
            sendText(Driver.getDriver(browser).findElement(By.name(locatorValue)),text, browser);
        }else if(locatorType.equalsIgnoreCase("className")){
            sendText(Driver.getDriver(browser).findElement(By.className(locatorValue)),text, browser);
        }
        else if(locatorType.equalsIgnoreCase("linktext")){
            sendText(Driver.getDriver(browser).findElement(By.linkText(locatorValue)),text, browser);
        }
        else if(locatorType.equalsIgnoreCase("partialLinkText")){
            sendText(Driver.getDriver(browser).findElement(By.partialLinkText(locatorValue)),text, browser);
        }
        else if(locatorType.equalsIgnoreCase("tagName")){
            sendText(Driver.getDriver(browser).findElement(By.tagName(locatorValue)),text, browser);
        }
        else if(locatorType.equalsIgnoreCase("cssSelector")){
            sendText(Driver.getDriver(browser).findElement(By.cssSelector(locatorValue)),text, browser);
        }
    }

    private enum WaitStrategy{
        INVISIBLE("presence"),VISIBLE("visible"),CLICKABLE("clickable"),NONE("none");
        private String theValue;
         private WaitStrategy(String value){
            this.theValue = value;
        }

        public String getTheValue() {
            return theValue;
        }


        private String theValue(){
           return theValue;
        }
    }

}
