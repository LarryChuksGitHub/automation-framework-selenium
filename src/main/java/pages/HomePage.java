package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.basepage.BasePage;
import drivers.Driver;

public final class HomePage extends BasePage {
    By searchButton = By.xpath("//button[@type='submit']");
    //By searchField = By.cssSelector("input.gLFyf.gsfi");
    //String searchField = "//input[@title='Search']";
    String searchField = "q";
    By search = By.name("q");
    By resultText = By.xpath("//h3[text()='Selenium']");
    String url = "https://the-internet.herokuapp.com/";
    String formAuthentication = "Form Authentication";
    By formAuth = By.linkText("Form Authentication");

    public HomePage openHomepage(String browser){
        Driver.getDriver(browser).get(url);
        return new HomePage();
    }
    public HomePage sendSearchText(String searchText, String browser){
       // System.out.println(Driver.getDriver().getPageSource());
       // click("name",searchField,"search Field");
        sendText("name",searchField,"searchfield",browser);
        click("name","q","search",browser);
        return this;
    }

    public String verifyDisplayText(String browser){
        WebElement element = Driver.getDriver(browser).findElement(resultText);
        return element.getText();
    }

    public LoginPage clickFormAuthentication(){
        //click("linkText",formAuthentication,"Form Authentication");
        //click("linkText", formAuth, "form Authentication" );
        click("linkText", "Form Authentication" ,"");
        return new LoginPage();
    }

}
