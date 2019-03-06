package code.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.ReflectPermission;

/**
 * @create by  单耀
 * @create date  2019/3/6
 */
public class JdkProxy implements InvocationHandler {
    private Object target;//需要代理的真实对象

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        if ("addUser".equals(method.getName())) {
            System.out.println("日志：添加新的user");
        }
        if ("delete".equals(method.getName())) {
            System.out.println("日志：删除user");
        }
        Object result = method.invoke(target, args);
        return result;
    }


    //获得代理对象
    public Object getProxy(){
        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 target.getClass().getClassLoader() ，我们这里使用target这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数target.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数this， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */


        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
