# Hystrix

### Hystrix设计理念

Hystrix是基于命令模式实现的，[了解命令模式](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter23_Command/Command.md)

### Hystrix的熔断机制

##### 熔断产生有两个必要条件：<br>


1. 达到错误比率(请求失败数/请求总数)(可配置)
2.  请求总数达到配置的最小请求数(可配置)

只有同时满足上面两个才会产生熔断，**注意：这两个值是有有效期的，每隔一段时间就会更新为0**，所以上面两个参数要根据自己业务的实际情况来配置，如果请求数量少时间长，而配置又比较高，那可能永远都不会产生熔断，这是请求就会走备用接口

##### 探测机制

当接口A被熔断一段时间(默认5000ms)后，Hystrix会分流部分请求回到接口A探测是否已经恢复，如果恢复则停止熔断。


### Hystrix内部流程

了解一些基本原理和基本机制后，来了解一下具体内部实现流程<br>
下面是一个官方的流程


参考链接：

[参考1](https://www.jianshu.com/p/138f92aa83dc)

[参考2](https://blog.csdn.net/harris135/article/details/77879148?locationNum=3&fps=1)

[参考3](https://blog.csdn.net/hry2015/article/details/78554846)

[参考4(比较详细)](https://blog.csdn.net/zjcsuct/article/details/78198632)

[参考5](http://hwood.lofter.com/post/1cc7fbdc_e8c5c96)

[参考6](https://blog.csdn.net/manzhizhen/article/details/80296655)





