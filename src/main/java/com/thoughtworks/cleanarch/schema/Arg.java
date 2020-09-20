package com.thoughtworks.cleanarch.schema;

public class Arg {
    private String flag;
    private String value;
    private String type;

    public Arg(String flag,String value){
        this.flag = flag;
        this.value = value;
    }

    public String getFlag() {
        return flag;
    }

    public Object parseValue(String flag){
        switch(flag){
            case "l":
                return Boolean.parseBoolean(value);
            case "p":
                return Integer.parseInt(value);
            case "d":
                return String.valueOf(value);
            default:
                return null;
        }
    }

    public boolean withFlag(){
        return false;
    }


    public String getValue() {
        return value;
    }



}
