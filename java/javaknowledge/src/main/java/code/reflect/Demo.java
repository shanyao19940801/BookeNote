package code.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
/*
 * 我们利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改
 * 我们只需要将新类发送给客户端，并修改配置文件即可
 */

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
