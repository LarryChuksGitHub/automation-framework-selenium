package pages;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.basepage.BasePage;

public class SecureAreaPage extends BasePage {

    private By succesLoginmessage = By.xpath("//div[@id='flash']");

    public String getSuccessMessage(String browser){
        //System.out.println( "This is the message: " + Driver.getDriver().findElement(succesLoginmessage).getText());

        WebElement element = Driver.getDriver(browser).findElement(succesLoginmessage);
        String elementText = getElementText(element,browser);
        return elementText;
       // Driver.getDriver().getTitle().contains("secure");
    }

}
