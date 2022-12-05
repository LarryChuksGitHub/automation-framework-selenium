package constants;

public final class FrameworkConstants {

    private FrameworkConstants(){}

    private static String resourcePath = System.getProperty("user.dir"+"");
    private static String chromeDriverPath = resourcePath+"/src/main/resources/selenium-driver-exec/chromedriver";
    private static String firefoxDriverPath = resourcePath + "/src/main/resources/selenium-driver-exec/geckodriver";
    private static String safariDriverPath = resourcePath + "/src/main/resources/selenium-driver-exec/safaridriver";
    private static String dataProviderPath = resourcePath + "/src/test/java/tutorial/dataprovider/workbook.xlsx";
    private static String configFilePath = resourcePath+ "/src/main/resources/config/properties";
    private static String jSondataProviderPath = resourcePath + "/src/test/java/tutorial/dataprovider/datafile.json";



    public static String getChromeDriver() {
        return chromeDriverPath;
    }

    public static String getFirefoxDriver() {
        return firefoxDriverPath;
    }
    public static String getSafariDriver() {
        return safariDriverPath;
    }

    public static void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver",getChromeDriver());
    }

    public static void setFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver",getFirefoxDriver());
    }
    public static void setSafariDriver() {
       // System.setProperty("webdriver.safari.driver",getSafariDriver());
    }


    public static String getConfigFilePath() {
        return configFilePath;
    }
    public static String getDataProviderPath() {
        return dataProviderPath;
    }
    public static void setDataProviderPath(String dataProviderPath) {
        FrameworkConstants.dataProviderPath = dataProviderPath;
    }
    public static String getjSondataProviderPath() {
        return jSondataProviderPath;
    }

}
