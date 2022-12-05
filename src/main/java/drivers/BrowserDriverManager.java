package drivers;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class BrowserDriverManager {

    private BrowserDriverManager(){}

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriverThreadLocal() {
        return driverThreadLocal.get();
    }


    public static void setDriverThreadLocal(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static void unloadDriverThreadLocal(){
        if (Objects.nonNull(driverThreadLocal)){
            driverThreadLocal.remove();
        }
    }


}
