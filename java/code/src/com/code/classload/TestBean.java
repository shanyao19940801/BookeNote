package com.code.classload;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class TestBean {
    public TestBean() {
    }

    public static void main(String[] args) throws Exception {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(filename);
                    if (is == null) {
                        return super.loadClass(name); //递归调用父类加载器
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return super.loadClass(name);
            }
        };
        Object obj = myClassLoader.loadClass("com.code.classload.TestBean").getDeclaredConstructor().newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.code.classload.TestBean);
    }
}
