# 享元模式

运用共享技术，有效地支持大量细粒度的对象。

* 结构图

![结构图](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter26_Flyweight/image/flyweight.PNG)

## 内部状态与外部状态

享元模式可以避免大量非常相似类的开销。在程序设计中，有时需要生成大量细粒度的类实例来表示数据。如果能发现这些实例除了几个参数外基本上都是相同的，有事就能够受大幅度地减少需要实例化的类的数量。如果能把那些参数移到类实例外面，在方法调用时将它们传递进来，就可以通过共享大幅度地减少单个实例的数目。

* 实例