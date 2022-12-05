package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import drivers.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport () {}
    private static String reportPagePath = "src/main/java/reports/reportoutput/"+System.currentTimeMillis()+"index.html";
    private static ExtentReports extentReports = new ExtentReports();
    private static ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPagePath);
    private  static ExtentTest report;


    private static ExtentTest getExtentTest(String reportName) {
        return createReport(reportName);
    }

    public static void configureReport(){
        sparkReporter.config().setReportName("Selenium Test report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Larry Report");
        sparkReporter.config().setDocumentTitle("Test Reports");
        extentReports.attachReporter(sparkReporter);
    }

    private static ExtentTest createReport(String reportName){
        configureReport();
        if (Objects.isNull(ExtententReportManager.getExtentThreadLocal())){
            report = extentReports.createTest(reportName);
            ExtententReportManager.setExtentThreadLocal(report);
        }
        return  ExtententReportManager.getExtentThreadLocal();
    }

    public static void publishReport(){
        if (Objects.nonNull(report))
        extentReports.flush();
        try {
            Desktop.getDesktop().browse(new File(reportPagePath).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
        quitExtendReport();
    }


    public static String getExtentTestStart(String report){
        report = getExtentTest(report).getStatus().getName();
        return report;
    }
    public static ExtentTest getExtentTestPass(String report){
        return getExtentTest(report).pass(report);
    }
    public static ExtentTest getExtentTestSkip(String report){
        return getExtentTest(report).skip(report);
    }

    public static ExtentTest getExtentTestFail(String message, String browser){
        return getExtentTest(message).fail(message,takeScreenshot(browser));
        // return null;
    }
    public static ExtentTest getExtentTestInfo(String info){
        return getExtentTest(info).info(info);
    }

    public static void quitExtendReport(){
        if(Objects.nonNull(ExtententReportManager.getExtentThreadLocal())) {
            extentReports.flush();
            ExtententReportManager.unloadExtentThreadLocal();
        }
    }

    private static Media takeScreenshot(String browser){
        String result = ((TakesScreenshot) Driver.getDriver(browser)).getScreenshotAs(OutputType.BASE64);
        Media media = MediaEntityBuilder.createScreenCaptureFromBase64String(result).build();
        return media;
    }

}
