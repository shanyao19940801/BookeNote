# Java动态代理

* 何为代理

	首先代理模式是一种[设计模式](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter07_daili/%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F.md)。正常情况下，我们访问一个对下个只需要实例化然后通过实例对象调用方法。而代理模式就是先创建一个代理对象，这个时候如果我们想要访问元对象的方法就可以通过代理对象访问。来个栗子：某天在上班的路上你看到一条非常可爱的狗，于是摸了一下，这时候狗主人不让了非说你非礼了她的狗狗，于是要把你告上法庭，可是你还要上班啊，没时间处理这些事，只好请个律师帮你处理了：你->律师->法官 律师就是你的代理对象。这时候肯定会有人问，干嘛这么麻烦绕一圈呢？直接调用不就好了。

* 为什么要用代理模式
	
	上面说到律师的例子，我们知道打官司费时费力还需要法律专业知识，我们自己肯定是搞不来的，而且我们有自己的事情要做没时间管这些事，这就需要我们的代理对象了：律师。把专业的或者繁琐的事情交给律师去处理。我们该干嘛干嘛只需要开庭的时候到场就可以了，开庭到场就是我们自己的方法，代理对象处理好开庭前的事情通知我就相当于调用我，开庭结束律师在处理后续事情。这就是代理的作用，把专业的繁琐的事情交给别人来做，我们只关心我们自己的事情就好了。

### Java动态代理

> java中动态代理主要用到java.lang.reflect包下的Proxy类InvocationHandler接口

* InvocationHandler

		public interface InvocationHandler {
		    public Object invoke(Object proxy, Method method, Object[] args)
		        throws Throwable;
		}
		proxy:　　指代我们所代理的那个真实对象
		method:　　指代的是我们所要调用真实对象的某个方法的Method对象
		args:　　指代的是调用真实对象某个方法时接受的参数


	每一个动态代理类都必须要实现InvocationHandler这个接口，并且每个代理类的实例都关联到了一个handler，当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用。我们来看看InvocationHandler这个接口的唯一一个方法 invoke 

* 看一个示例
 
	只贴了代理类，[完整代码](https://github.com/shanyao19940801/BookeNote/tree/master/java/javaknowledge/src/main/java/code/dynamic_proxy)

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
		         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
		         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
		         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
		         */
		        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		    }
		}

	上面还应用了[Java的反射](https://github.com/shanyao19940801/BookeNote/blob/master/java/file/Java%E5%8F%8D%E5%B0%84.md)

	<font color = red>注意，通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，它并不是我们的InvocationHandler类型，也不是我们定义的那组接口的类型，而是在运行是动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号。</font>下面查看一下生成的动态代理类

* 查看动态代理类

首先在[测试类](https://github.com/shanyao19940801/BookeNote/blob/master/java/javaknowledge/src/main/java/code/dynamic_proxy/Main.java)的main中添加如下几行代码,这样就会生成对应的代理类的class文件(<font color=bule>这几行代码只能在jdk9之前的版本中</font>)

	byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", target.getClass().getInterfaces());
	        String path = "E:/my_git/UserServiceProxy.class";
	        try(FileOutputStream fos = new FileOutputStream(path)) {
	            fos.write(classFile);
	            fos.flush();
	            System.out.println("代理类class文件写入成功");
	        } catch (Exception e) {
	            System.out.println("写文件错误");
	        }

代理类内容如下：


	import code.dynamic_proxy.User;
	import code.dynamic_proxy.UserService;
	import java.lang.reflect.InvocationHandler;
	import java.lang.reflect.Method;
	import java.lang.reflect.Proxy;
	import java.lang.reflect.UndeclaredThrowableException;
	
	public final class $Proxy0 extends Proxy implements UserService {
	    private static Method m1;
	    private static Method m3;
	    private static Method m0;
	    private static Method m4;
	    private static Method m2;
		//可以看到这个构造函数的参数时InvocationHandler，这就可以理解为什么每次调用都会通过InvocationHandler的invoke来执行的了
	    public $Proxy0(InvocationHandler var1) throws  {
		//将InvocationHandler对象赋值到父类
	        super(var1);
	    }
	
	    public final boolean equals(Object var1) throws  {
	        try {
	            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
	        } catch (RuntimeException | Error var3) {
	            throw var3;
	        } catch (Throwable var4) {
	            throw new UndeclaredThrowableException(var4);
	        }
	    }
	
	    public final void delete(User var1) throws  {
	        try {
	            super.h.invoke(this, m3, new Object[]{var1});
	        } catch (RuntimeException | Error var3) {
	            throw var3;
	        } catch (Throwable var4) {
	            throw new UndeclaredThrowableException(var4);
	        }
	    }
	
	    public final int hashCode() throws  {
	        try {
	            return (Integer)super.h.invoke(this, m0, (Object[])null);
	        } catch (RuntimeException | Error var2) {
	            throw var2;
	        } catch (Throwable var3) {
	            throw new UndeclaredThrowableException(var3);
	        }
	    }
	
	    public final void addUser(User var1) throws  {
	        try {
	            super.h.invoke(this, m4, new Object[]{var1});
	        } catch (RuntimeException | Error var3) {
	            throw var3;
	        } catch (Throwable var4) {
	            throw new UndeclaredThrowableException(var4);
	        }
	    }
	
	    public final String toString() throws  {
	        try {
	            return (String)super.h.invoke(this, m2, (Object[])null);
	        } catch (RuntimeException | Error var2) {
	            throw var2;
	        } catch (Throwable var3) {
	            throw new UndeclaredThrowableException(var3);
	        }
	    }
	
	    static {
	        try {
	            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
	            m3 = Class.forName("code.dynamic_proxy.UserService").getMethod("delete", Class.forName("code.dynamic_proxy.User"));
	            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
	            m4 = Class.forName("code.dynamic_proxy.UserService").getMethod("addUser", Class.forName("code.dynamic_proxy.User"));
	            m2 = Class.forName("java.lang.Object").getMethod("toString");
	        } catch (NoSuchMethodException var2) {
	            throw new NoSuchMethodError(var2.getMessage());
	        } catch (ClassNotFoundException var3) {
	            throw new NoClassDefFoundError(var3.getMessage());
	        }
	    }
	}

### 拓展
这里留个坑<br>
jdk动态代理和cglib动态代理的区别，Spring的Aop功能主要借助的就是动态代理实现的，不过aop用了jdk和cglib两中动态代理
