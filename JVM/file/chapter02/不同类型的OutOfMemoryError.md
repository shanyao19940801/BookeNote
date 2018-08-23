# OutOfMemoryError

## java堆溢出

		-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCdetails -XX:SurvivorRatio=8
上面命令限制Java堆的大小为20MB,不可扩展（将堆的最小值-Xms20M与最大值-Xmx20M设置一样就可以避免自动扩展）

	[测试代码](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/codeshow/src/com/jvm/chapter02/HeapOOM.java)


## 虚拟机栈和本地方法栈溢出

* 限制方法栈大小：

    **-Xss128k**

* 测试代码

	[测试代码](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/codeshow/src/com/jvm/chapter02/JavaVMStackSOF.java)


* 执行结果

		Exception in thread "main" stack length:31792
		java.lang.StackOverflowError
			at com.jvm.chapter02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:8)
			at com.jvm.chapter02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:8)
			at com.jvm.chapter02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:8)

