# Java编程思想

## 第七章：复用类

### 复用类的几种方式


* 组合语法

	在一个类中定义另一个累的成员变量达到复用


* 继承语法
* 代理
* 结合使用组合和继承

通过继承复用

### 7.1
1. 类中基本类型会被初始化为0

### 7.2

1. 当创建一个子类对象时，该对象包含了父类的一个子对象，该子对象初始化是在子类的构造器中(java会自动在构造器中插入对父类构造器的调用)

### 7.3

SpaceShipControls飞船控制类，SpaceShip飞船类，如果需要操控飞船可以让SpaceShip继承SpaceShipControls，这样就可以通过SpaceShip控制，**但这样就暴露了SpaceShip**，这时候就可以使用代理来解決，新建一个SpaecShipDelegation如下：

	public class SpaecShipDelegation {
	    private String name;
	    private SpaceShipControls controls = new SpaceShipControls();
	
	    public SpaecShipDelegation(String name) {
	        this.name = name;
	    }
	    public void up(int ve) {
	        controls.up(ve);
	    }
	    public void down(int ve) {
	        controls.down(ve);
	    }
	}

这样来控制飞船
