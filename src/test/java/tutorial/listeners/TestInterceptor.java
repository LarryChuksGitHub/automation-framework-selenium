package tutorial.listeners;

import org.testng.*;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import java.util.*;

public class TestInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methodList, ITestContext iTestContext) {


        Map<String, String> map1 = new HashMap<>();
        map1.put("name","test1");
        map1.put("count","2");

        Map<String, String> map2 = new HashMap<>();
        map2.put("name","test2");
        map2.put("count","3");




        List<Map<String, String>> mapList = new ArrayList<>();

        mapList.add(map1);
        mapList.add(map2);

        List<IMethodInstance> result = new ArrayList<>();
        for (int i= 0 ; i < methodList.size(); i++ ){
            for (int j = 0; j < mapList.size(); j ++){
                if (methodList.get(i).getMethod().getMethodName().equalsIgnoreCase(mapList.get(j).get("name"))){
                    methodList.get(i).getMethod().setInvocationCount(Integer.parseInt(mapList.get(j).get("count")));
                    result.add(methodList.get(i));
                }

            }
        }
        for (IMethodInstance method : result){
            System.out.println("The methods are: "+ method.getMethod().getMethodName());
        }
        return result;
    }

    @Test
    public void test1(){
        System.out.println("running test1 on TestInterceptor");
    }
    @Test
    public void test2(){
        System.out.println("running test2 on TestInterceptor");
    }
    @Test
    public void test3(){
        System.out.println("running test3 on TestInterceptor");
    }
}
