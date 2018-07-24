# 单例模式

作为对象的创建模式，单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。这个类称为单例类。

#### 常见的实现方式：从以下8中实现方式讲解

	1）懒汉式，线程不安全
	2）懒汉式，线程安全
	3）恶汉式
	4）恶汉式，变种
	5）静态内部类
	6）双重检验锁
	7）登记式


* 懒汉式，线程不安全


	public class Singleton {
	    private static Singleton instance;
	    private Singleton() {
	    }
	    public static Singleton getInstance(){
	        if (instance == null) {
	            instance = new Singleton();
	        }
	        return instance;
	    }
	}


* 懒汉式，线程安全
	在获取是对方法上加上同步锁，虽然线程安全但是效率很低


	public class Singleton {
	    private static Singleton instance;
	    private Singleton() {
	    }
	    public static synchronized Singleton getInstance() {
	        if (instance == null) {
	            instance = new Singleton();
	        }
	        return instance;
	    }
	}


* 恶汉式

类一加载时就实例化

	public class Singleton {
	    private static Singleton instance = new Singleton();
	    private Singleton (){
	    }
	    public static Singleton getInstance() {
	        return instance;
	    }
	}

* 恶汉式，变种

将实例化代码放到静态代码中

	public class Singleton {
	    private static Singleton instance = null;
	    static {
	        instance = new Singleton();
	    }
	    private Singleton (){}
	    public static Singleton getInstance() {
	        return instance;
	    }
	}

* 静态内部类


	public class Singleton {
	    private static class SingletonHolder {
	        private static final Singleton instance = new Singleton();
	    }
	    private Singleton (){}
	    public static final Singleton getInstance(){
	        return SingletonHolder.instance;
	    }
	}


* 双重检验锁


	public class Singleton {
	    private volatile static Singleton instance;
	    private Singleton() {
	    }
	    public static Singleton getSingleton() {
	        if (instance == null) { // null 检测
	            synchronized (Singleton.class) { // 同步检测
	                if (instance == null) {
	                    instance = new Singleton();
	                }
	            }
	        }
	        return instance;
	    }
	}