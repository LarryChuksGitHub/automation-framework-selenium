package logger;

import reports.ExtentReport;

public final class ConsoleLogImpl implements ILoggable{
    @Override
    public void log(String status, String message) {
        String BrowserType = null;
        if(status.equalsIgnoreCase(LogType.PASS.name())){
            System.out.println(message);
            ExtentReport.getExtentTestPass(message);
        }else if (status.equalsIgnoreCase(LogType.FAIL.name())){
            System.out.println(message);
            ExtentReport.getExtentTestFail(message,BrowserType);
        }
        else if (status.equalsIgnoreCase(LogType.SKIP.name())){
            System.out.println(message);
            ExtentReport.getExtentTestSkip(message);
        }else if (status.equalsIgnoreCase(LogType.INFO.name())){
            System.out.println(message);
            ExtentReport.getExtentTestInfo(message);
        }

    }
}
