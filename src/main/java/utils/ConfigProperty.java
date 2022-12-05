package utils;

public enum ConfigProperty {
    BROWSER ("browser"),
    CHROME ("chrome"),
    FIREFOX ("firefox"),
    URL ("url"),
    EXECUTIONENVIRONMENT ("executionenvironment"),
    RETRYFAILEDTETS("retryfailedtests");


    ConfigProperty(String value) {
        this.theValue = value;
    }

    public String getTheValue() {
        return theValue;
    }

    private String theValue;


}
