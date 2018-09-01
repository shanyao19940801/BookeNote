# 深入理解java虚拟机

## 第二章


[内存泄漏和内存溢出的区别](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/file/chapter02/%E5%86%85%E5%AD%98%E6%B3%84%E6%BC%8F%E5%92%8C%E5%86%85%E5%AD%98%E6%BA%A2%E5%87%BA%E7%9A%84%E5%8C%BA%E5%88%AB.md)

[不同类型的OutOfMemoryError](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/file/chapter02/不同类型的OutOfMemoryError.md)

## 第三章：垃圾收集器与内存分配策略

[哪些内存需要垃圾回收器去回收](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/file/chapter03/%E5%9E%83%E5%9C%BE%E6%94%B6%E9%9B%86%E5%99%A8%E4%B8%8E%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D%E7%AD%96%E7%95%A5.md)

[判断对象是否活着的几种方法](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/file/chapter03/%E5%88%A4%E6%96%AD%E5%AF%B9%E8%B1%A1%E6%98%AF%E5%90%A6%E6%B4%BB%E7%9D%80.md)

1. 引用计数法
2. 可达性分析法

* 对象被回收至少要经过两次标记(p66)

下面这段代码一个对象被回收的过程

[FinalizeEscapeGC](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/codeshow/src/com/jvm/chapter03/FinalizeEscapeGC.java)

[垃圾收集算法](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/file/chapter03/%E5%9E%83%E5%9C%BE%E6%94%B6%E9%9B%86%E7%AE%97%E6%B3%95.md)

[新生代和老年代](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/file/chapter03/Java%E5%86%85%E5%AD%98%E6%96%B0%E7%94%9F%E4%BB%A3%E5%92%8C%E8%80%81%E5%B9%B4%E4%BB%A3.md)


[JVM的Client与Server模式](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/file/JVM%E4%B8%A4%E7%A7%8D%E5%90%AF%E5%8A%A8%E6%A8%A1%E5%BC%8F.md)

* 3.5

[垃圾收集器](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/file/chapter03/%E5%90%84%E7%A7%8D%E5%9E%83%E5%9C%BE%E6%94%B6%E9%9B%86%E5%99%A8.md)

* 3.6

[内存分配与回收策略](https://github.com/shanyao19940801/BookeNote/blob/master/JVM/file/chapter03/%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D%E4%B8%8E%E5%9B%9E%E6%94%B6%E7%AD%96%E7%95%A5.md)

