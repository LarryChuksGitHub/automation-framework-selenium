package tutorial.listeners;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Annotationtransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);


        Map<String, Object> map1 = new HashMap<>();
        map1.put("name","test1");
        map1.put("count","2");
        map1.put("enabled",true);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name","test2");
        map2.put("count","3");
        map2.put("enabled",false);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("name","test3");
        map3.put("count","3");
        map3.put("enabled",true);

        List<Map<String,Object>> mapList = new ArrayList<>();
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        for (int i = 0; i < mapList.size(); i++){
            if (mapList.get(i).get("name").equals(testMethod.getName())){
                if (mapList.get(i).get("enabled").equals(false)){
                    annotation.setEnabled(false);
                    //annotation.setAlwaysRun(false);
                }else {
                    annotation.setEnabled(true);
                   // annotation.setInvocationCount((Integer.parseInt((String) mapList.get(i).get("count"))));
                    annotation.setRetryAnalyzer(RetryTestExecution.class);
                }

            }

        }

    }

    @Test
    public void test1(){
        System.out.println("running test1 on Annotationtransformer");
        Assert.assertTrue(true);
    }
    @Test
    public void test2(){
        System.out.println("running test2 on Annotationtransformer");
    }
    @Test
    public void test3(){
        System.out.println("running test3 on Annotationtransformer");
    }
}
