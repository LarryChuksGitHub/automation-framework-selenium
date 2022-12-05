package facade;

import pages.HomePage;

public class LoginFacade {

    public String naviagteToLoginPageAndDoLogin(String username, String password , String browser, String method){
        String result =
      new HomePage()
              .openHomepage(browser)
              .clickFormAuthentication()
              .sendTextToUsernameField(username,browser)
              .sendTextToPasswordField(password, browser).clickLoginButton(browser).getSuccessMessage(browser);

      return result;
    }
}
