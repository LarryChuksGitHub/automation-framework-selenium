package tutorial.enumdemo;

public enum Country {
    NIGERIA ("nigeria"),
    TOGO ("togo") ,
    GERMANY ("germany"),
    INDIA ("india");

    private String theValue;

    Country(String value) {
        theValue =  value;
    }

    public String getValue() {
        return theValue;
    }
    public void setValue(String value) {
        this.theValue = value;
    }

}

