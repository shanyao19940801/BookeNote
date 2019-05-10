# Hystrix

### Hystrix设计理念

Hystrix是基于命令模式实现的，[了解命令模式](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter23_Command/Command.md)

Hystrix主要就是做了**Command**这一块的工作，它把用户的请求包装起来执行各种操作。

### Hystrix的熔断机制

##### 熔断产生有两个必要条件：<br>


1. 达到错误比率(请求失败数/请求总数)(可配置)
2.  请求总数达到配置的最小请求数(可配置)

只有同时满足上面两个才会产生熔断，**注意：这两个值是有有效期的，每隔一段时间就会更新为0**，所以上面两个参数要根据自己业务的实际情况来配置，如果请求数量少时间长，而配置又比较高，那可能永远都不会产生熔断，这是请求就会走备用接口

##### 探测机制

当接口A被熔断一段时间(默认5000ms)后，Hystrix会分流部分请求回到接口A探测是否已经恢复，如果恢复则停止熔断。


### Hystrix内部流程

了解一些基本原理和基本机制后，来了解一下具体内部实现流程<br>
下面是一个官方的流程图：

![流程图官方](https://github.com/shanyao19940801/BookeNote/blob/master/Hystrix/files/hystrix-command-flow-chart.png)
	
* 流程说明:
	
		1:每次调用创建一个新的HystrixCommand,把依赖调用封装在run()方法中.
		2:执行execute()/queue做同步或异步调用.
		3:判断熔断器(circuit-breaker)是否打开,如果打开跳到步骤8,进行降级策略,如果关闭进入步骤.
		4:判断线程池/队列/信号量是否跑满，如果跑满进入降级步骤8,否则继续后续步骤.
		5:调用HystrixCommand的run方法.运行依赖逻辑
		5a:依赖逻辑调用超时,进入步骤8.
		6:判断逻辑是否调用成功
		6a:返回成功调用结果
		6b:调用出错，进入步骤8.
		7:计算熔断器状态,所有的运行状态(成功, 失败, 拒绝,超时)上报给熔断器，用于统计从而判断熔断器状态.
		8:getFallback()降级逻辑.
		  以下四种情况将触发getFallback调用：
		 (1):run()方法抛出非HystrixBadRequestException异常。
		 (2):run()方法调用超时
		 (3):熔断器开启拦截调用
		 (4):线程池/队列/信号量是否跑满
		8a:没有实现getFallback的Command将直接抛出异常
		8b:fallback降级逻辑调用成功直接返回
		8c:降级逻辑调用失败抛出异常
		9:返回执行成功结果

### Hystrix的断路器设计


#### 两种请求命令

Hystrix有两个请求命令 **HystrixCommand**、**HystrixObservableCommand**。

　**HystrixCommand**用在依赖服务返回单个操作结果的时候。又两种执行方式

　　  -execute():同步执行。从依赖的服务返回一个单一的结果对象，或是在发生错误的时候抛出异常。

　　  -queue();异步执行。直接返回一个Future对象，其中包含了服务执行结束时要返回的单一结果对象。


　**HystrixObservableCommand** 用在依赖服务返回多个操作结果的时候。它也实现了两种执行方式

　　  -observe():返回Obervable对象，他代表了操作的多个结果，他是一个HotObservable

　　  -toObservable():同样返回Observable对象，也代表了操作多个结果，但它返回的是一个Cold Observable。

参考链接：

[参考1](https://www.jianshu.com/p/138f92aa83dc)

[参考2(参数详解)](https://blog.csdn.net/harris135/article/details/77879148?locationNum=3&fps=1)

[参考3](https://blog.csdn.net/hry2015/article/details/78554846)

[参考4(比较详细)](https://blog.csdn.net/zjcsuct/article/details/78198632)

[参考5](http://hwood.lofter.com/post/1cc7fbdc_e8c5c96)

[参考6(断路器讲的比较好)](https://blog.csdn.net/manzhizhen/article/details/80296655)

[参考7(资源隔离)](https://blog.csdn.net/xuxian6823091/article/details/81546235)

[参考8(资源隔离)](https://blog.csdn.net/liuchuanhong1/article/details/73718794)



