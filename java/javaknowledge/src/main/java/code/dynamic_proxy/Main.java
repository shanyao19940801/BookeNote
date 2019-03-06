package code.dynamic_proxy;

//import sun.misc.ProxyGenerator;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

/**
 * @create by  单耀
 * @create date  2019/3/6
 */
public class Main {
    public static void main(String[] args) {
        UserServiceImpl target = new UserServiceImpl();
        JdkProxy proxy = new JdkProxy(target);
        UserService userService = (UserService) proxy.getProxy();
        User user = new User();
        user.setAge(1);
        user.setName("shan");
        userService.addUser(user);
        userService.delete(user);
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", target.getClass().getInterfaces());
        String path = "E:/my_git/$Proxy0.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
}
