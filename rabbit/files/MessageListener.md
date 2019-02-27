# MessageListener
[参考资料](https://www.cnblogs.com/gordonkong/p/7115155.html)


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