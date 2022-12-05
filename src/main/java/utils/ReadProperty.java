package utils;

import constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class ReadProperty {

    private ReadProperty(){}

    private static Properties properties = new Properties();
    private static Map<String, String> map = new HashMap<>();

    public static String getPropertyValue(ConfigProperty key){
           return map.get(key.name().toLowerCase());
    }

    public static String getRetryOption(ConfigProperty key){
        String result = "";
        if (map.containsKey("retryfailedtests")){
            System.out.println("The retry failed tests: " + result);
            System.out.println("The retry failed tests value is: " + map.get("retryfailedtests"));
            return result = map.get(key);
        }
        return result;
    }
    static {
        {
            try (FileInputStream  fileInputStream = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
                properties.load(fileInputStream);
                properties.forEach((k,v)-> System.out.println("The key "+k +" : " +" the value "+v));
                for (Map.Entry<Object,Object > entry : properties.entrySet()){
                    String key = String.valueOf(entry.getKey());
                    String value = String.valueOf(entry.getValue()).trim();
                    map.put(key,value);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("The path to the file is not correct");
                System.exit(0);
            }

        }
    }

    public static void main(String[] args) {
        getRetryOption(ConfigProperty.RETRYFAILEDTETS);
    }

}
