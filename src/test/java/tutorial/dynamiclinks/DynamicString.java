package tutorial.dynamiclinks;

public class DynamicString {



    public static void main(String[] args) {
        String a = "You better come";
        String b = " see how";
        String c = " deal with stress";
        String d = " the exam time";

       // System.out.println(a +" and " + b +" to " + c + " at" + d);
      String temp = String.format("%s and %s to %s at %s",a,b,c,d);
        System.out.println(temp);

    }
}
