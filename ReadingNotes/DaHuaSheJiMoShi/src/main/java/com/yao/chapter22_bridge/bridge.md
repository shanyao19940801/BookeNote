# 桥接模式
将抽象部分与它的实现部分分离，使它们都可以独立的变化

<br>
<br>**什么叫抽象与它的现实分离，这并不是说，让抽象类与其派生类分离，因为这没有意义。实现指的是抽象类和它的派生类用来实现自己的对象**或者**实现系统可能有多角度分类，每一种分类都有可能变化，那么就把这种多角度分离出来让他们独立变化，减少他们之间的耦合**
<br>
比如下面的例子：手机既可以按照品牌来分类，也可以按照功能来分类
<br>
按照品牌分离结构图：

![结构图](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter22_bridge/image/bridge1.PNG)

按照软件分离结构图

![结构图](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter22_bridge/image/bridge2.PNG)


**由于实现方式有多种**，桥接模式的核心意图就是把这些实现独立出来，让他们各自地变化。这就使得每种实现的变化不会影响其他实现，从而达到对应变化的目的。

* 使用桥接模式的结构图

![结构图](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter22_bridge/image/bridge3.PNG)

* 结构图：

![桥接模式](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter22_bridge/image/bridge.PNG) 