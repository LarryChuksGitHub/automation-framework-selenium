package logger;

import lombok.extern.java.Log;
import reports.ExtentReport;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public final class FrameworkLogger {

    private FrameworkLogger(){}

    private static Consumer<String> PASS = (message) -> ExtentReport.getExtentTestPass(message);
    private static Consumer<String> FAIL = (message) -> ExtentReport.getExtentTestFail(message,"");
    private static Consumer<String> SKIP = (message) -> ExtentReport.getExtentTestSkip(message);
    private static Consumer<String> INFO = (message) -> ExtentReport.getExtentTestInfo(message);
    private static Consumer<String> PASSCONSOLE = (message) -> System.out.println(message);
    private static Consumer<String> PASSCONSOLEANDEXTENT = PASS.andThen(PASSCONSOLE);

    private static Map<LogType, Consumer<String>> map = new HashMap<>();

    static {
        map.put(LogType.PASS,PASS);
        map.put(LogType.FAIL,FAIL);
        map.put(LogType.SKIP,SKIP);
        map.put(LogType.INFO,INFO);
        map.put(LogType.PASSCONSOLEANDEXTENT,PASSCONSOLEANDEXTENT);
    }

    public static void log(LogType status, String message){
            map.get(status).accept(message);
           // Map<Enum,Consumer<String>> log = Map.of(status,PASS, status,INFO);
           // log.getOrDefault(status,INFO);
    }

}
