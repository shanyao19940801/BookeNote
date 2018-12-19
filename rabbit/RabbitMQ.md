# RabbitMQ

[学习参考文档](https://blog.csdn.net/phker/article/details/71211895)
[很不错的一篇文章](https://mp.weixin.qq.com/s/r8L-Nz_457xdsww2DdlqJw)
* 消费者down了，信息会丢失吗？

不会，只要queue存在消息就一直存在

* 消息系统的分布式可扩展的实现在于消息广播, 集群性的实现在于邮箱队列. 

* 如何将将消息放松到多个Queue
RabbitMQ消息队列-通过fanout模式将消息推送到多个Queue中


几个名词概念:

1. Exchange: 就是邮局的概念等同于 中国邮政和顺丰快递、 
1. routingkey: 就是邮件地址的概念. 
1. queue: 就是邮箱接收软件，但是可以接收多个地址的邮件，通过bind实现。 
1. producer： 消息生产者，就是投递消息的程序。 
1. consumer：消息消费者，就是接受消息的程序。 
1. channel：消息通道，在客户端的每个连接里，可建立多个channel，每个channel代表一个会话任务。

### 三种Exchange

[参考地址](https://www.cnblogs.com/hz04022016/p/6519445.html)

性能排序：fanout > direct >> topic。比例大约为11：10：6

#### 一.Fanout Exchange

**任何发送到Fanout Exchange的消息都会被转发到与该Exchange绑定(Binding)的所有Queue上。**
1.可以理解为路由表的模式

2.这种模式不需要RouteKey

3.这种模式需要提前将Exchange与Queue进行绑定，一个Exchange可以绑定多个Queue，一个Queue可以同多个Exchange进行绑定。

4.如果接受到消息的Exchange没有与任何Queue绑定，则消息会被抛弃。

* 应用场景

	
	第一：大型玩家在玩在线游戏的时候，可以用它来广播重大消息。这让我想到电影微微一笑很倾城中，有款游戏需要在世界上公布玩家重大消息，也许这个就是用的MQ实现的。这让我不禁佩服肖奈，人家在大学的时候就知道RabbitMQ的这种特性了。
	
	第二：体育新闻实时更新到手机客户端。
	
	第三：群聊功能，广播消息给当前群聊中的所有人。
* 
[Java代码demo](https://github.com/shanyao19940801/demos/tree/master/rabbitMQ/comrabbitmq/src/main/java/com/rabbitmq/fanout)

#### 二.Direct Exchange

**任何发送到Direct Exchange的消息都会被转发到RouteKey中指定的Queue。**

1.一般情况可以使用rabbitMQ自带的Exchange：”"(该Exchange的名字为空字符串，下文称其为default Exchange)。

2.这种模式下不需要将Exchange进行任何绑定(binding)操作

3.消息传递时需要一个“RouteKey”，可以简单的理解为要发送到的队列名字。

4.如果vhost中不存在RouteKey中指定的队列名，则该消息会被抛弃。

#### 三.Topic Exchange

**任何发送到Topic Exchange的消息都会被转发到所有关心RouteKey中指定话题的Queue上**

1.这种模式较为复杂，简单来说，就是每个队列都有其关心的主题，所有的消息都带有一个“标题”(RouteKey)，Exchange会将消息转发到所有关注主题能与RouteKey模糊匹配的队列。

2.这种模式需要RouteKey，也许要提前绑定Exchange与Queue。

3.在进行绑定时，要提供一个该队列关心的主题，如“#.log.#”表示该队列关心所有涉及log的消息(一个RouteKey为”MQ.log.error”的消息会被转发到该队列)。

4.“#”表示0个或若干个关键字，“*”表示一个关键字。如“log.*”能与“log.warn”匹配，无法与“log.warn.timeout”匹配；但是“log.#”能与上述两者匹配。

5.同样，如果Exchange没有发现能够与RouteKey匹配的Queue，则会抛弃此消息。

[Java代码demo](https://github.com/shanyao19940801/demos/tree/master/rabbitMQ/comrabbitmq/src/main/java/com/rabbitmq/topic)

#### 一些注意点

不要在业务程序中用代码定义创建 邮局 ExChange. 和邮箱Queue队列 这属于系统设计者要构架的事情. 要有专门独立的程序和规则去创建. 这样可以统一管理事件类型.避免过多的乱七八糟的RoutingKey混乱.

#### 小结

1. 消息系统的分布式可扩展的实现在于消息广播, 集群性的实现在于邮箱队列. 
1. RabbitMQ是先广播后队列的.

