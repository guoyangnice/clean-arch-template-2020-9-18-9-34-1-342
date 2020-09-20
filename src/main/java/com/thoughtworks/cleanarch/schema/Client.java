package com.thoughtworks.cleanarch.schema;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class Client {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FlagsSchema flagsSchemaL = new FlagsSchema("l",Boolean.TYPE);
        FlagsSchema flagsSchemaP = new FlagsSchema("p",Integer.TYPE);
        FlagsSchema flagsSchemaD = new FlagsSchema("d",String.class);
        Set<FlagsSchema> flagsSchemas = new HashSet();
        flagsSchemas.add(flagsSchemaL);
        flagsSchemas.add(flagsSchemaP);
        flagsSchemas.add(flagsSchemaD);
        Schema schema = new Schema(flagsSchemas);
        Args args1 = new Args("l true",schema);
        System.out.println(args1.getValueOf("l"));
    }
}
