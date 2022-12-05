package homepagetest;

import basetest.BaseTest;
import facade.HomepageFacade;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Map;

import static drivers.Driver.*;

public class HomePageTests extends BaseTest {

    @Test
    public static void test(Map<String,String> map){
        String browser = map.get("browser");
        new HomepageFacade()
                .getHomePage()
                .openHomepage("chrome")
                .sendSearchText("selenium",browser);
        var enter = Keys.ENTER;
        String result = new HomePage().verifyDisplayText(browser);
        Assertions.assertThat(result).isNotBlank().isNotNull().contains("Selenium");
    }

}
