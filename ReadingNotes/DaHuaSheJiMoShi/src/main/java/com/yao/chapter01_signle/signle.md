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
	在获取是对方法上加上同步锁

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