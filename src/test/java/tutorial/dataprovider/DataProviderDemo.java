package tutorial.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    @Test(dataProvider = "studentData")
    public void runDataTest(Student student){
        System.out.println(student.getMatNumber());
        System.out.println(student.getName());
        System.out.println(student.getAddress());

    }

    @DataProvider(name = "studentData")
    public Student [] getData(){
       return new Student[]{
               new Student(1,"Larry","Luckeweg"),
               new Student(2,"Ebu","Teterower")
       };
    }

    @Test(dataProvider = "objectData", dataProviderClass = DataProviderDemo.class)
    public void runDataTest2(int matNumber, String name, String address){
        System.out.println(matNumber);
       System.out.println(name);
        System.out.println(address);

    }
    @DataProvider(name = "objectData")
    public Object [][]getData2(){
        return new Object[][]{
                {1,"Larry","Luckeweg"},
                {2,"Ebu","Teterower"}
        };
    }

}
