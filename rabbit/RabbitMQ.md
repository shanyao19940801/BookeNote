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

---
## AMQP协议
* MessageListener源码分析
[MessageListener](https://github.com/shanyao19940801/BookeNote/blob/master/rabbit/files/MessageListener.md)