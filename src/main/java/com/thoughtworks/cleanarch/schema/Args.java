package com.thoughtworks.cleanarch.schema;

import java.util.*;
import java.util.stream.Collectors;

public class Args {
    private String argsText;
    private List<Arg> argsPairs;
    private Schema schema;

    public Args(String argsText,Schema schema){
        this.argsText = argsText;
        this.schema = schema;
    }

    public List<Arg> scan(){
        List<String> keyValueStringList = Arrays.asList(argsText.split(" -"));
        keyValueStringList = keyValueStringList.stream().map(String::trim).collect(Collectors.toList());
        List<Arg> keyValuePairs = new ArrayList<>();
        for(String kv : keyValueStringList){
            String key = kv.split(" ")[0];
            String value = kv.split(" ")[1];
            Arg arg = new Arg(key,value);
            keyValuePairs.add(arg);
        }
        return keyValuePairs;
    }

    public Object getValueOf(String flag){
        argsPairs = new Args(argsText,schema).scan();
        for(int i = 0;i < argsPairs.size();i++){
            for(int j = 0; j < schema.flagsSchema.size();j++){
                if(flag.equals(schema.flagsSchema.toArray()[i])){
                    return argsPairs.get(i).parseValue();
                }
            }
        }
        return null;
    }
}
