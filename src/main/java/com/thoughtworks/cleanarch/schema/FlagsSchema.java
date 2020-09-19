package com.thoughtworks.cleanarch.schema;

public class FlagsSchema {
    private String flag;
    private Object valueType;

    public FlagsSchema(String flag,Object valueType){
        this.flag = flag;
        this.valueType = valueType;
    }

    public Object getType(){
        return valueType;
    }

    public boolean equalsWith(String flag){
        return flag.equals(this.flag);
    }
}
