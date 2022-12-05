package pages;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.basepage.BasePage;

public final class LoginPage extends BasePage {

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@type='password' and @name='password' and @id='password']");
    private  By loginButton = By.xpath("//button[@type='submit']");


    private void clickUsername(String browser){
        WebElement element = Driver.getDriver(browser).findElement(username);
       // click(element,username);
        click("xpath",username,"username",browser);
    }
    private void clickPassword(String browser){
        click("xpath",password,"password",browser);
    }

    public LoginPage sendTextToUsernameField(String usernameData, String browser){
        clickUsername(browser);
        WebElement element = Driver.getDriver(browser).findElement(username);
        sendText(element,usernameData, browser);
        return new LoginPage();
    }
    public LoginPage sendTextToPasswordField(String passwordData ,String browser){
        clickPassword(browser);
        WebElement element = Driver.getDriver(browser).findElement(password);
        sendText(element,passwordData, browser);
        return new LoginPage();
    }

    public SecureAreaPage clickLoginButton(String browser){
        click("xpath",loginButton,"login button",browser);
        return new SecureAreaPage();
    }


}
