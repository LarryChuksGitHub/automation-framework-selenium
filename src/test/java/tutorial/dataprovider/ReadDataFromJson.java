package tutorial.dataprovider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FrameworkConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadDataFromJson {

    @Test(dataProvider = "jsonMapData")
    public void runDataTest1(Map<String,String> map){
        System.out.println("username: " +map.get("username"));
        System.out.println("password: " +map.get("password"));
        System.out.println("TelNumber: " +map.get("telNumber"));
        System.out.println("Address: "+ map.get("address"));
        System.out.println("----------------------------");

    }
    @DataProvider(name = "jsonMapData")
    public Object[] getMapData() {
        HashMap<Object,Object> map = null;
        try {

                map = new ObjectMapper().readValue(new File(FrameworkConstants.getjSondataProviderPath()), HashMap.class);
                map.forEach((k,v)-> System.out.println("key " +k + " : " + " value " +v));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Object[]{map};
    }


}
