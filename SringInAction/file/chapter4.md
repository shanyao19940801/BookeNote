# 面向切面的Spring

## 4.1 什麽是什么是面向切面编程

### 4.1.1 AOP术语
------
1. **通知**： 就是我们编写的希望Aop时执行的那个方法。我们通过Aop希望我们编写的方法在目标方法执行前执行，或者执行后执行。
2. **切点**：切点就是我们我们配置的满足我们条件的目标方法。比如我们规定：名字前面是select开头的才执行我们自定义的通知方法。那么这些select开头的方法就是切点。
3. **连接点**：连接点可以说是切点的全集。切点是连接点的子集。也可以理解为，连接点是我们没有定义那个select开头规则时，满足条件的全部的方法。
4. **切面**：切面是切点和通知的组合称谓，就是变相给组合起了个名字。
 
------

#### 通知（advice）

> 切面的工作被称为通知

* Spring切面可以应用5种类型的通知：

	- 前置通知
	- 后置通知
	- 返回通知
	- 异常通知
	- 环绕通知

#### 连接点

> 连接点是在应用执行过程中能够插入切面的一个点，这个点可以是调用方法时，抛出异常时，甚至修改一个字段时。切面代码可以利用这些点插入到应用的正常流程中，并添加新的行为

#### 切点

切点定义了通知被应用的具体位置（**在哪些连接点**）

#### 切面

#### 引入



#### 织入

织入是把切面应用到目标对象并创建新的代理对象的过程中。切面在指定的连接点被织入到目标对象中。目标对象的生命周期里有多个点可以进行织入：

* 编译期
* 类加载期
* **运行期**(SpringAOP的使用方式)

### 4.1.2Spring对AOP的支持

Spring支持方法级别的连接点

## 4.2 通过切点来选择连接点

###4.2.1 编写切点

	public interface Performance {
	    /**
	     * 一个切点
	     */
	    public void perform();
	}

* 切点表达式

		execution(** chapter04.Performance.perform(..))

上面是一个切点表达式，该表示设置当perform()方法执行时触发通知的调用。

### 4.2.2 定义一个切面

	//注解定义切面
	@Aspect
	public class Audience {
	    //前置通知
	    //使用切点表达式指定切点
		@Before("execution(** chapter04.Performance.perform(..))")
	    public void silenceCellPhone() {
	        System.out.println("关闭手机");
	    }
	    //前置通知
	    //使用切点表达式指定切点
		@Before("execution(** chapter04.Performance.perform(..))")
	    public void takeSeats() {
	        System.out.println("坐好");
	    }
	    //后置通知
	    //使用切点表达式指定切点
		@AfterReturning("execution(** chapter04.Performance.perform(..))")
	    public void applause() {
	        System.out.println("鼓掌");
	    }
	    //异常通知
		//使用切点表达式指定切点
	    @AfterThrowing("execution(** chapter04.Performance.perform(..))")
	    public void demandRefund() {
	        System.out.println("失败了，没关系，重新开始！");
	    }
	}

可以看到上面是定义的一个切面，使用切点表达式指定了切点，使用注解定义了几个通知，前置通知，后置统治，异常通知。**但是从代码中我们可以看到，相同的切点表达式我们使用了多次，这非常不好**

* 使用@Pointcut定义一个可重用的切点

