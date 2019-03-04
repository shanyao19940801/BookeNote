# RabbitMQ

## RabbitMQ基础知识

[很不错的系列文章](https://www.cnblogs.com/gordonkong/p/6939043.html)

[学习参考文档](https://blog.csdn.net/phker/article/details/71211895)

[很不错的一篇文章](https://mp.weixin.qq.com/s/r8L-Nz_457xdsww2DdlqJw)

* 消费者down了，信息会丢失吗？

不会，只要queue存在消息就一直存在

* 消息系统的分布式可扩展的实现在于消息广播, 集群性的实现在于邮箱队列. 

* 如何将将消息放松到多个Queue
RabbitMQ消息队列-通过fanout模式将消息推送到多个Queue中

---

[基础知识](https://github.com/shanyao19940801/BookeNote/blob/master/rabbit/files/%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86.md)

##
[推拉模式](https://github.com/shanyao19940801/BookeNote/blob/master/rabbit/files/%E6%8E%A8%E6%8B%89%E6%A8%A1%E5%BC%8F.md)
##
[公平分发（fair dispatch）](https://github.com/shanyao19940801/BookeNote/blob/master/rabbit/files/%E5%85%AC%E5%B9%B3%E5%88%86%E5%8F%91%EF%BC%88fair%20dispatch%EF%BC%89.md)
##

[消息确认Ack](https://github.com/shanyao19940801/BookeNote/blob/master/rabbit/files/%E6%B6%88%E6%81%AF%E7%A1%AE%E8%AE%A4Ack.md)

## 
[方法说明](https://github.com/shanyao19940801/BookeNote/blob/master/rabbit/files/%E6%96%B9%E6%B3%95%E8%AF%B4%E6%98%8E.md)

##

[死信队列](https://blog.csdn.net/qq_29778131/article/details/52536965)

## 
[如何确保消息发送和消费](https://github.com/shanyao19940801/BookeNote/blob/master/rabbit/files/%E5%A6%82%E4%BD%95%E7%A1%AE%E4%BF%9D%E6%B6%88%E6%81%AF%E5%8F%91%E9%80%81%E5%92%8C%E6%B6%88%E8%B4%B9.md)

---
## AMQP协议
* MessageListener源码分析

	[MessageListener](https://github.com/shanyao19940801/BookeNote/blob/master/rabbit/files/MessageListener.md)<br>
	[SimpleMessageListenerContainer](https://blog.csdn.net/yangbo10086/article/details/81322139)``

### RabbitMq高级应用
[RabbitAdmin，RabbitTemplate，SimpleMessageListenerContailer](https://github.com/shanyao19940801/BookeNote/blob/master/rabbit/files/springampq/rabbitmq%E9%AB%98%E7%BA%A7%E5%BA%94%E7%94%A8.md)

