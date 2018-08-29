# JVM两种运行模式Server与Client

JVM有两种运行模式Server与Client。两种模式的区别在于，Client模式启动速度较快，Server模式启动较慢；但是启动进入稳定期长期运行之后Server模式的程序运行速度比Client要快很多。这是因为Server模式启动的JVM采用的是重量级的虚拟机，对程序采用了更多的优化；而Client模式启动的JVM采用的是轻量级的虚拟机。所以Server启动慢，但稳定后速度比Client远远要快。

* 查看虚拟机是哪种模式

打开cmd输入java -version，就可以看到，如下我的是Server模式

	C:\Users\shanyao>java -version
	java version "9.0.4"
	Java(TM) SE Runtime Environment (build 9.0.4+11)
	Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)


* 如何切换

[参考](https://www.cnblogs.com/wxw7blog/p/7221756.html)