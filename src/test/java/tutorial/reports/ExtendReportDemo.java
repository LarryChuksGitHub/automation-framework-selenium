package tutorial.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ExtendReportDemo {
    private static String reportPagePath = "src/test/java/tutorial/reports/index.html";
    private static ExtentReports extentReports = new ExtentReports();
    private static ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPagePath);

    public static void configureReport(){
        sparkReporter.config().setReportName("Selenium Test report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Larry Report");
        sparkReporter.config().setDocumentTitle("Test Reports");
        extentReports.attachReporter(sparkReporter);
    }

    public static ExtentTest createReport(String testMethodName){
        configureReport();
        ExtentTest report = null;
        report = extentReports.createTest(testMethodName);
        report.pass("Test passed");
        report.fail("Test failed");
        report.skip("Test skipped");

        return  report;
    }

    public static void publishReport(){
        createReport("test1");
        extentReports.flush();
        try {
            Desktop.getDesktop().browse(new File(reportPagePath).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        publishReport();
    }

    public static void main(String[] args) {
        publishReport();

    }
}
