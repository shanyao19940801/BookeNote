# 适配器模式

将一个接口转接成客户希望的另外一个接口。使得原来由于接口不兼容而不能一起工作的哪些类可以在一起工作

* 结构图

![适配器模式](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter17_Adapter/image/adpter.PNG)

**优点**： 1、可以让任何两个没有关联的类一起运行。 2、提高了类的复用。 3、增加了类的透明度。 4、灵活性好。

**缺点**： 1、过多地使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。 2.由于 JAVA 至多继承一个类，所以至多只能适配一个适配者类，而且目标类必须是抽象类。
使用场景：有动机地修改一个正常运行的系统的接口，这时应该考虑使用适配器模式。

**注意事项**：适配器不是在详细设计时添加的，而是解决正在服役的项目的问题。

	package com.thinkf.chapter09.c03;
	
	public class Test29 {
	    public static void main(String[] args){
	
	        PowerA a = new PowerAImpl();
	
	        //connect(a);
	
	        PowerB b = new PowerBImpl();
	
	        PowerAdapter pa = new PowerAdapter(b);
	
	        connect(pa);
	
	    }
	
	    //此方法只能接收PowerA接口，不兼容其它接口
	
	    public static void connect(PowerA powerA){
	
	        System.out.println("开始工作之前的准备");
	
	        powerA.connect();
	
	
	
	        //
	
	    }
	
	       /*
	
	       public static void insert(PowerB powerB){
	
	              powerB.insert();
	
	       }
	
	       */
	
	}
	
	//适配器：实现的接口表示要匹配的接口，内部维护的接口表示被匹配的接口
	
	class PowerAdapter implements PowerA{
	
	    private PowerB powerB;
	
	    public PowerAdapter(PowerB powerB){
	
	        this.powerB = powerB;
	
	    }
	
	    public void connect(){
	
	        powerB.insert();
	
	    }
	
	}
	
	
	
	//电源A
	
	interface PowerA{
	
	    public void connect();
	
	}
	
	class PowerAImpl implements PowerA{
	
	    public void connect(){
	
	        System.out.println("电源A已连接，开始工作");
	
	    }
	
	}
	
	//电源B
	
	interface PowerB{
	
	    public void insert();
	
	}
	
	class PowerBImpl implements PowerB{
	
	    public void insert(){
	
	        System.out.println("电源B已插入，开始工作");
	
	    }
	
	}

