package com.code.reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws Exception {
        Class stuClass = Class.forName(getValue("className"));
        Method m = stuClass.getMethod(getValue("methodName"), String.class);

        m.invoke(stuClass.getConstructor().newInstance(),"shanyao");

    }

    public static String getValue(String key) throws IOException {
        Properties properties = new Properties();
        FileReader in = new FileReader("E:\\my_git\\BookeNote\\java\\code\\src\\com\\code\\reflect\\pro.txt");
        properties.load(in);
        in.close();
        return properties.getProperty(key);
    }
}
