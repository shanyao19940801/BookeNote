# MessageListener
[参考资料](https://www.cnblogs.com/gordonkong/p/7115155.html)

## 测试代码

	public class AsyncConsumer {
	    public static void main(String[] args) throws Exception {
	        URI uri = new URI("amqp://shanyao:123456@47.100.211.121:5672");
	        ConnectionFactory connectionFactory = new CachingConnectionFactory(uri);
	        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
	        container.setConcurrentConsumers(1);
	        container.setQueueNames("queue");
	        container.setMessageListener(new MessageListener() {
	            public void onMessage(Message message) {
	                System.out.println("received: " + message);
	            }
	        });
	        container.start();
	
	        AmqpTemplate template = new RabbitTemplate(connectionFactory);
	        template.convertAndSend("queue", "foo");
	        template.convertAndSend("queue", "bar");
	        template.convertAndSend("queue", "tui");
	    }
	}


## MessageListener
<font color=red>org.springframework.amqp.core.MessageListener</font> 是 Spring AMQP 异步消息投递的监听器接口，它只有一个方法 onMessage，用于处理消息队列推送来的消息。
	
	public interface MessageListener {
	    void onMessage(Message var1);
	
	    default void containerAckMode(AcknowledgeMode mode) {
	    }
	}

MessageListener 大概对应 amqp client 中的 Consumer 类。onMessage 方法大概对应 Consumer 类的 handleDelivery 方法。

## MessageListenerContainer

<font color=red>org.springframework.amqp.rabbit.listener.MessageListenerContainer</font> 可以看作 message linstener 的容器。但这个 Container 的语义并不是指它包含多个 message listener，实际上从方法注释和实现代码可以看出，**MessageListenerContainer 只包含一个 MessageListener** 。那 Container 的语义是什么呢？

一方面，Container 是指虽然只有一个 MessageListener 指定消息消费的逻辑，<font color=green>但是可以生成多个线程使用相同的 MessageListener 同时消费消息</font>。代码第19行 setConcurrentConsumers 方法就是用来指定并发消费者的数量。可以把 MessageListenerContainer 看成下图中的 Subscriber group

![p_1](https://github.com/shanyao19940801/BookeNote/blob/master/rabbit/pictures/MessageListenerContainer_1.png)

另一方面，<font color=green>Container代表生命周期管理的职责</font>。**MessageListener 仅仅实现消息消费逻辑**，而整个消息消费何时开始、何时结束、如何设置、状态怎样等等问题全都是由 MessageListenerContainer（及其实现类）负责的。实际上MessageListenerContainer 继承自 SmartLifecycle 接口，该接口是 Spring 容器提供的与生命周期管理相关的接口，实现该接口的类一般情况下会由 Spring 容器负责启动与停止。由于本例没有启用 Spring 容器环境，所以代码第26行需要主动调用 start 方法，消息消费才会开始执行。