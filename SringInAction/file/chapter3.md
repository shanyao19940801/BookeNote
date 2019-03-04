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

### 3.4bean的作用域

有以下几种作用域：

1. 单利(Singleton)
1. 原型(Prototype):每次注入或者通过Spring应用上下文获取的时候，都会创建一个新的bean实例
2. 会话(Session):在Web应用中，为每个会话创建一个Bean实例
3. 请求(Request):在Web应用中，为每个请求创建一个bean实例
  		

*  会话作用域

典型应用：购物车。购物车的bean用单例模式显然不合适，用原型的话如果在某个地方添加商品到应用的另外一个地方可能就不能用了，**所以会话作用域是最为合适的** 

### 3.5运行时值注入

#### 3.5.1注入外部的值


使用@PropertySource注解和Environment，[测试代码](https://github.com/shanyao19940801/BookeNote/blob/master/SringInAction/springinaction/chapter02/src/main/java/chapter03/c03/MainTest.java)

	@Configuration
	//声明属性源
	@PropertySource("classpath:app.properties")
	public class ExpressiveConfig {
	    @Autowired
	    Environment environment;
	
	    @Bean
	    public BlankDisc disc() {
	        return new BlankDisc(environment.getProperty("disc.title"));
	    }
	}

##### 解析属性占位符

属性占位符：${}这种方式直接从源中获取值，如下面代码实例，[测试代码](https://github.com/shanyao19940801/BookeNote/blob/master/SringInAction/springinaction/chapter02/src/main/java/chapter03/c03/ExpressiveConfigV1Test.java)

	@Configuration
	//声明属性源
	@PropertySource("classpath:app.properties")
	public class ExpressiveConfigV1 {
	    @Value(value = "${disc.title}")
	    String title;
	    @Bean
	    public BlankDisc blankDisc(){
	        return new BlankDisc(title);
	    }
	}

