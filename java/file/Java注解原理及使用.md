# Java注解原理以及使用

java注解是在JDK5时引入的新特性

### 注解分类
* 按照运行机制分类

![p1](https://github.com/shanyao19940801/BookeNote/blob/master/java/pictures/%E6%B3%A8%E8%A7%A3%E5%88%86%E7%B1%BB0.png)
![p1](https://github.com/shanyao19940801/BookeNote/blob/master/java/pictures/%E6%B3%A8%E8%A7%A3%E5%88%86%E7%B1%BB.png)
![p1](https://github.com/shanyao19940801/BookeNote/blob/master/java/pictures/%E6%B3%A8%E8%A7%A3%E5%88%86%E7%B1%BB2.png)

* 按照来源来分的话，有如下三类：

		1：JDK自带的注解（Java目前只内置了三种标准注解：@Override、@Deprecated、@SuppressWarnings，以及四种元注解：@Target、@Retention、@Documented、@Inherited）
		2：第三方的注解——这一类注解是我们接触最多和作用最大的一类
		3：自定义注解——也可以看作是我们编写的注解，其他的都是他人编写注解

 

* 按照功能来分的，还有，元注解——注解的注解。


### Java内置三个注解

	1.      @Override，表示当前的方法定义将覆盖超类中的方法。
	1.      @Deprecated，使用了注解为它的元素编译器将发出警告，因为注解@Deprecated是不赞成使用的代码，被弃用的代码。
	1.      @SuppressWarnings，关闭不当编译器警告信息。


### Java还提供了4中元注解，专门负责新注解的创建

* **@Target**

	表示该注解可以用于什么地方，可能的ElementType参数有：
	
	1. 	CONSTRUCTOR：构造器的声明
	1. 	FIELD：域声明（包括enum实例）
	1. 	LOCAL_VARIABLE：局部变量声明
	1. 	METHOD：方法声明
	1. 	PACKAGE：包声明
	1. 	PARAMETER：参数声明
	1. 	TYPE：类、接口（包括注解类型）或enum声明
* **@Retention**

	表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：

	1. SOURCE：注解将被编译器丢弃
	1. CLASS：注解在class文件中可用，但会被VM丢弃
	1. RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息。


* **@Document**

	将注解包含在Javadoc中

* **@Inherited**

	允许子类继承父类中的注解

### 自定义一个注解

	@Target({ElementType.TYPE, ElementType.METHOD})
	@Retention(RUNTIME)
	@Inherited
	public @interface MyAnnotation {
	    NameEnum value() default NameEnum.yao;
	}


### Java8注解新特性
[Java8注解](http://ifeve.com/java-annotations-tutorial/)

### 参考文档

[参考一](https://www.cnblogs.com/Qian123/p/5256084.html#_label0)<br>
[参考二](http://www.cnblogs.com/huajiezh/p/5263849.html)<br>
[参考三](https://blog.csdn.net/javazejian/article/details/71860633#%E7%90%86%E8%A7%A3java%E6%B3%A8%E8%A7%A3)
