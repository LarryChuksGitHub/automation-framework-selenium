package tutorial.enumdemo;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class EnumDemo {

    public static void main(String[] args) {

       // Enum
        CounrtyName theLand = CounrtyName.INDIA;
       String  result = theLand.toString();
        System.out.println("theLand: "+ result);

       Country land = Country.valueOf("NIGERIA");
       Arrays.asList(Country.values()).forEach(System.out:: println);
        System.out.println("--------------------------");
        Arrays.asList(Country.values()).forEach(country -> System.out.println(country));
       switch (land){
           case NIGERIA -> System.out.println("print Nigeria");
           case TOGO -> System.out.println("print Togo");
       }

       if(land == (Country.NIGERIA)){
           System.out.println("Naija");
       }else if (land.equals("Togo")){
           System.out.println("Togo");
       }

        Map<Country,String> map = new EnumMap<Country, String>(Country.class);
       map.put(Country.NIGERIA,"Nigeria");
       map.put(Country.TOGO, "togo");
       map.forEach((k,v)-> System.out.println(v));

       //String nig = Country.NIGERIA.getLowerCase();
        int nigTo = Country.NIGERIA.compareTo(Country.INDIA);
       // System.out.println("Naija lower case: " +nig);
        //String tog = Country.TOGO.getLowerCase();
        //System.out.println("Tog lower case: " +tog);
        List<Country> name = Arrays.stream(Country.values()).toList();
        System.out.println("the name: "+ name);
        System.out.println("Comapre: "+ nigTo);
        String resultInd = Country.INDIA.getValue();
        System.out.println("Print small cap india: " + resultInd);
    }
}
