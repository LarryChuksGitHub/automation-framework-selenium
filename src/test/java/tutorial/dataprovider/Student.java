package tutorial.dataprovider;

public class Student {


    private int matNumber;
    private String name;
    private String address;

    public Student(int matNumber, String name, String address) {
        this.matNumber = matNumber;
        this.name = name;
        this.address = address;
    }
    public int getMatNumber() {
        return matNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
