package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtententReportManager {

    private ExtententReportManager(){}

    private static ThreadLocal<ExtentTest> extentThreadLocal = new ThreadLocal<>();

    static ExtentTest getExtentThreadLocal() {
        return extentThreadLocal.get();
    }


    public static void setExtentThreadLocal(ExtentTest extentTest) {
        extentThreadLocal.set(extentTest);
    }

    public static void unloadExtentThreadLocal(){
        extentThreadLocal.remove();
        //extentThreadLocal = null;
    }

}
