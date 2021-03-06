# 中介模式

用一个中介对象来封装一系列的对象交互。中介者使个对象不需要显示地互相引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。

* 结构图

![](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter25_Mediator/image/meditor.PNG)

![](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter25_Mediator/image/meditor1.PNG)

* 优点

1.减少了各个Colleague之间的耦合，使得可以独立的改变和复用各个Colleague类和Mediator<br>
2.由于把对象如何协作进行了抽象，将中介作为一个独立的概念并将其封装在一个对象中，这样关注的对象就从对象各自本身的行为转移到他们之间的交互上来，也就是站在了一个更宏观的角度去看待系统。

* 缺点

由于ConcreteMondiator控制了集中化，于是就把交互复杂性变成了中介者的复杂性，这就使得中介者会变得比任何一个ConcreteColleague都复杂