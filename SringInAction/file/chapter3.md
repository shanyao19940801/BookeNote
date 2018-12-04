# 第三章 高级装配

### 3.1 环境与profile

利用profile来实现根据环境来确定创建哪个bean不创建哪个bean

### 条件化的bean

利用@Conditional注解实现达到某个条件才会去创建这个Bean

### 处理自动装配的歧义性

* 使用场景

	我当我们想要把一个bean引用注入到构造参数和属性中时，只有一个bean匹配时自动装配才是有效的否则会报错。**如果确实就是有多个bean匹配该怎么办呢？**下面几种方式可以解决这个问题

* 1.标示首选的bean

声明bean的时候将其中一个可选的bean设置为首选，这样自动装配就会选择这个bean



1. 隐式装配：

	@Primary
	@Component
	public class IceCream implements Dessert {
	}


1. 显示装配

