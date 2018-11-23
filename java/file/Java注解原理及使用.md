# Java注解原理以及使用

java注解是在JDK5时引入的新特性

### Java内置三个注解

1.      @Override，表示当前的方法定义将覆盖超类中的方法。
1.      @Deprecated，使用了注解为它的元素编译器将发出警告，因为注解@Deprecated是不赞成使用的代码，被弃用的代码。
1.      @SuppressWarnings，关闭不当编译器警告信息。


### Java还提供了4中注解，专门负责新注解的创建

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

