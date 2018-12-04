# 第三章 高级装配

### 3.1 环境与profile

利用profile来实现根据环境来确定创建哪个bean不创建哪个bean

### 3,2条件化的bean

利用@Conditional注解实现达到某个条件才会去创建这个Bean

### 3.3处理自动装配的歧义性

* 使用场景

	我当我们想要把一个bean引用注入到构造参数和属性中时，只有一个bean匹配时自动装配才是有效的否则会报错。**如果确实就是有多个bean匹配该怎么办呢？**下面几种方式可以解决这个问题，

#### 1.标示首选的bean

声明bean的时候将其中一个可选的bean设置为首选，这样自动装配就会选择这个bean，**注意只能在一个bean标识首选**



1. 隐式装配：

		@Primary
		@Component
		public class IceCream implements Dessert {
		}


1. 显示装配

	    @Bean
	    @Primary
	    public Dessert iceCream() {
	        return new IceCream();
	    }

#### 2.限定自动装配的bean

	标识首选方法只能选择一个优先的方案，当首选数量超过一个没有其他方法缩小范围，而**Spring的限定符能实现缩小范围操作最终只有一个bean满足限定条件**

* @Qualifier注解

@Qualifier注解是使用限定符的主要方式

    @Autowired
    @Qualifier("iceCrem")//将指定ID的bean注入其中
    public Dessert iceCream(Dessert dessert) {
        this.dessert = dessert;
    }

* 自定义一个限定符注解

当你想在一个bean加多个@Qualifier注解时会报错，这时候可以用下面这个方式创建一个限定符注解

		@Target({ElementType.METHOD,ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.FIELD})
		@Retention(RetentionPolicy.RUNTIME)
		@Qualifier
		public @interface Cold {
		}
